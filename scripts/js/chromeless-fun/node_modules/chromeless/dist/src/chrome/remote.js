"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = y[op[0] & 2 ? "return" : op[0] ? "throw" : "next"]) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [0, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
Object.defineProperty(exports, "__esModule", { value: true });
var mqtt_1 = require("mqtt");
var got = require("got");
function getEndpoint(remoteOptions) {
    if (typeof remoteOptions === 'object' && remoteOptions.endpointUrl) {
        return remoteOptions;
    }
    if (process.env['CHROMELESS_ENDPOINT_URL'] &&
        process.env['CHROMELESS_ENDPOINT_API_KEY']) {
        return {
            endpointUrl: process.env['CHROMELESS_ENDPOINT_URL'],
            apiKey: process.env['CHROMELESS_ENDPOINT_API_KEY'],
        };
    }
    throw new Error('No Chromeless remote endpoint & API key provided. Either set as "remote" option in constructor or set as "CHROMELESS_ENDPOINT_URL" and "CHROMELESS_ENDPOINT_API_KEY" env variables.');
}
var RemoteChrome = (function () {
    function RemoteChrome(options) {
        this.options = options;
        this.connectionPromise = this.initConnection();
    }
    RemoteChrome.prototype.initConnection = function () {
        return __awaiter(this, void 0, void 0, function () {
            var _this = this;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, new Promise(function (resolve, reject) { return __awaiter(_this, void 0, void 0, function () {
                            var _this = this;
                            var timeout, _a, endpointUrl, apiKey, _b, url, channelId_1, channel_1, error_1;
                            return __generator(this, function (_c) {
                                switch (_c.label) {
                                    case 0:
                                        timeout = setTimeout(function () {
                                            if (_this.channel) {
                                                _this.channel.end();
                                            }
                                            reject(new Error("Timed out after 30sec. Connection couldn't be established."));
                                        }, 30000);
                                        _c.label = 1;
                                    case 1:
                                        _c.trys.push([1, 3, , 4]);
                                        _a = getEndpoint(this.options.remote), endpointUrl = _a.endpointUrl, apiKey = _a.apiKey;
                                        return [4 /*yield*/, got(endpointUrl, {
                                                headers: apiKey
                                                    ? {
                                                        'x-api-key': apiKey,
                                                    }
                                                    : undefined,
                                                json: true,
                                            })];
                                    case 2:
                                        _b = (_c.sent()).body, url = _b.url, channelId_1 = _b.channelId;
                                        this.channelId = channelId_1;
                                        this.TOPIC_NEW_SESSION = 'chrome/new-session';
                                        this.TOPIC_CONNECTED = "chrome/" + channelId_1 + "/connected";
                                        this.TOPIC_REQUEST = "chrome/" + channelId_1 + "/request";
                                        this.TOPIC_RESPONSE = "chrome/" + channelId_1 + "/response";
                                        this.TOPIC_END = "chrome/" + channelId_1 + "/end";
                                        channel_1 = mqtt_1.connect(url, {
                                            will: {
                                                topic: 'chrome/last-will',
                                                payload: JSON.stringify({ channelId: channelId_1 }),
                                                qos: 1,
                                                retain: false,
                                            },
                                        });
                                        this.channel = channel_1;
                                        if (this.options.debug) {
                                            channel_1.on('error', function (error) { return console.log('WebSocket error', error); });
                                            channel_1.on('offline', function () { return console.log('WebSocket offline'); });
                                        }
                                        channel_1.on('connect', function () {
                                            if (_this.options.debug) {
                                                console.log('Connected to message broker.');
                                            }
                                            channel_1.subscribe(_this.TOPIC_CONNECTED, { qos: 1 }, function () {
                                                channel_1.on('message', function (topic) { return __awaiter(_this, void 0, void 0, function () {
                                                    return __generator(this, function (_a) {
                                                        if (this.TOPIC_CONNECTED === topic) {
                                                            clearTimeout(timeout);
                                                            resolve();
                                                        }
                                                        return [2 /*return*/];
                                                    });
                                                }); });
                                                channel_1.publish(_this.TOPIC_NEW_SESSION, JSON.stringify({ channelId: channelId_1, options: _this.options }), { qos: 1 });
                                            });
                                            channel_1.subscribe(_this.TOPIC_END, function () {
                                                channel_1.on('message', function (topic, buffer) { return __awaiter(_this, void 0, void 0, function () {
                                                    var message, data;
                                                    return __generator(this, function (_a) {
                                                        switch (_a.label) {
                                                            case 0:
                                                                if (!(this.TOPIC_END === topic)) return [3 /*break*/, 2];
                                                                message = buffer.toString();
                                                                data = JSON.parse(message);
                                                                if (data.outOfTime) {
                                                                    console.warn("Chromeless Proxy disconnected because it reached it's execution time limit (5 minutes).");
                                                                }
                                                                else if (data.inactivity) {
                                                                    console.warn('Chromeless Proxy disconnected due to inactivity (no commands sent for 30 seconds).');
                                                                }
                                                                else {
                                                                    console.warn("Chromeless Proxy disconnected (we don't know why).", data);
                                                                }
                                                                return [4 /*yield*/, this.close()];
                                                            case 1:
                                                                _a.sent();
                                                                _a.label = 2;
                                                            case 2: return [2 /*return*/];
                                                        }
                                                    });
                                                }); });
                                            });
                                        });
                                        return [3 /*break*/, 4];
                                    case 3:
                                        error_1 = _c.sent();
                                        console.error(error_1);
                                        reject(new Error('Unable to get presigned websocket URL and connect to it.'));
                                        return [3 /*break*/, 4];
                                    case 4: return [2 /*return*/];
                                }
                            });
                        }); })];
                    case 1:
                        _a.sent();
                        return [2 /*return*/];
                }
            });
        });
    };
    RemoteChrome.prototype.process = function (command) {
        return __awaiter(this, void 0, void 0, function () {
            var _this = this;
            var promise;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: 
                    // wait until lambda connection is established
                    return [4 /*yield*/, this.connectionPromise];
                    case 1:
                        // wait until lambda connection is established
                        _a.sent();
                        if (this.options.debug) {
                            console.log("Running remotely: " + JSON.stringify(command));
                        }
                        promise = new Promise(function (resolve, reject) {
                            _this.channel.subscribe(_this.TOPIC_RESPONSE, function () {
                                _this.channel.on('message', function (topic, buffer) {
                                    if (_this.TOPIC_RESPONSE === topic) {
                                        var message = buffer.toString();
                                        var result = JSON.parse(message);
                                        if (result.error) {
                                            reject(result.error);
                                        }
                                        else if (result.value) {
                                            resolve(result.value);
                                        }
                                        else {
                                            resolve();
                                        }
                                    }
                                });
                                _this.channel.publish(_this.TOPIC_REQUEST, JSON.stringify(command));
                            });
                        });
                        return [2 /*return*/, promise];
                }
            });
        });
    };
    RemoteChrome.prototype.close = function () {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                this.channel.publish(this.TOPIC_END, JSON.stringify({ channelId: this.channelId, client: true }));
                this.channel.end();
                return [2 /*return*/];
            });
        });
    };
    return RemoteChrome;
}());
exports.default = RemoteChrome;
//# sourceMappingURL=remote.js.map