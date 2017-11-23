"use strict";
var __assign = (this && this.__assign) || Object.assign || function(t) {
    for (var s, i = 1, n = arguments.length; i < n; i++) {
        s = arguments[i];
        for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p))
            t[p] = s[p];
    }
    return t;
};
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
var fs = require("fs");
var path = require("path");
var CDP = require("chrome-remote-interface");
exports.version = (function () {
    if (fs.existsSync(path.join(__dirname, '../package.json'))) {
        // development (look in /src)
        return require('../package.json').version;
    }
    else {
        // production (look in /dist/src)
        return require('../../package.json').version;
    }
})();
function setViewport(client, viewport) {
    if (viewport === void 0) { viewport = { width: 1, height: 1, scale: 1 }; }
    return __awaiter(this, void 0, void 0, function () {
        var config, versionResult, isHeadless, _a, _b;
        return __generator(this, function (_c) {
            switch (_c.label) {
                case 0:
                    config = {
                        deviceScaleFactor: 1,
                        mobile: false,
                        scale: viewport.scale || 1,
                        fitWindow: false,
                    };
                    return [4 /*yield*/, CDP.Version()];
                case 1:
                    versionResult = _c.sent();
                    isHeadless = versionResult['User-Agent'].includes('Headless');
                    if (!(viewport.height && viewport.width)) return [3 /*break*/, 2];
                    config.height = viewport.height;
                    config.width = viewport.width;
                    return [3 /*break*/, 6];
                case 2:
                    if (!isHeadless) return [3 /*break*/, 3];
                    // just apply default value in headless mode to maintain original browser viewport
                    config.height = 900;
                    config.width = 1440;
                    return [3 /*break*/, 6];
                case 3:
                    _a = config;
                    return [4 /*yield*/, evaluate(client, (function () { return window.innerHeight; }).toString())];
                case 4:
                    _a.height = _c.sent();
                    _b = config;
                    return [4 /*yield*/, evaluate(client, (function () { return window.innerWidth; }).toString())];
                case 5:
                    _b.width = _c.sent();
                    _c.label = 6;
                case 6: return [4 /*yield*/, client.Emulation.setDeviceMetricsOverride(config)];
                case 7:
                    _c.sent();
                    return [4 /*yield*/, client.Emulation.setVisibleSize({
                            width: config.width,
                            height: config.height,
                        })];
                case 8:
                    _c.sent();
                    return [2 /*return*/];
            }
        });
    });
}
exports.setViewport = setViewport;
function waitForNode(client, selector, waitTimeout) {
    return __awaiter(this, void 0, void 0, function () {
        var _this = this;
        var Runtime, getNode, result, start_1;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    Runtime = client.Runtime;
                    getNode = function (selector) {
                        return document.querySelector(selector);
                    };
                    return [4 /*yield*/, Runtime.evaluate({
                            expression: "(" + getNode + ")(`" + selector + "`)",
                        })];
                case 1:
                    result = _a.sent();
                    if (result.result.value === null) {
                        start_1 = new Date().getTime();
                        return [2 /*return*/, new Promise(function (resolve, reject) {
                                var interval = setInterval(function () { return __awaiter(_this, void 0, void 0, function () {
                                    var result;
                                    return __generator(this, function (_a) {
                                        switch (_a.label) {
                                            case 0:
                                                if (new Date().getTime() - start_1 > waitTimeout) {
                                                    clearInterval(interval);
                                                    reject(new Error("wait(\"" + selector + "\") timed out after " + waitTimeout + "ms"));
                                                }
                                                return [4 /*yield*/, Runtime.evaluate({
                                                        expression: "(" + getNode + ")(`" + selector + "`)",
                                                    })];
                                            case 1:
                                                result = _a.sent();
                                                if (result.result.value !== null) {
                                                    clearInterval(interval);
                                                    resolve();
                                                }
                                                return [2 /*return*/];
                                        }
                                    });
                                }); }, 500);
                            })];
                    }
                    else {
                        return [2 /*return*/];
                    }
                    return [2 /*return*/];
            }
        });
    });
}
exports.waitForNode = waitForNode;
function wait(timeout) {
    return __awaiter(this, void 0, void 0, function () {
        return __generator(this, function (_a) {
            return [2 /*return*/, new Promise(function (resolve, reject) { return setTimeout(resolve, timeout); })];
        });
    });
}
exports.wait = wait;
function nodeExists(client, selector) {
    return __awaiter(this, void 0, void 0, function () {
        var Runtime, exists, expression, result;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    Runtime = client.Runtime;
                    exists = function (selector) {
                        return !!document.querySelector(selector);
                    };
                    expression = "(" + exists + ")(`" + selector + "`)";
                    return [4 /*yield*/, Runtime.evaluate({
                            expression: expression,
                        })];
                case 1:
                    result = _a.sent();
                    return [2 /*return*/, result.result.value];
            }
        });
    });
}
exports.nodeExists = nodeExists;
function getClientRect(client, selector) {
    return __awaiter(this, void 0, void 0, function () {
        var Runtime, code, expression, result;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    Runtime = client.Runtime;
                    code = function (selector) {
                        var element = document.querySelector(selector);
                        if (!element) {
                            return undefined;
                        }
                        var rect = element.getBoundingClientRect();
                        return JSON.stringify({
                            left: rect.left,
                            top: rect.top,
                            right: rect.right,
                            bottom: rect.bottom,
                            height: rect.height,
                            width: rect.width,
                        });
                    };
                    expression = "(" + code + ")(`" + selector + "`)";
                    return [4 /*yield*/, Runtime.evaluate({ expression: expression })];
                case 1:
                    result = _a.sent();
                    if (!result.result.value) {
                        throw new Error("No element found for selector: " + selector);
                    }
                    return [2 /*return*/, JSON.parse(result.result.value)];
            }
        });
    });
}
exports.getClientRect = getClientRect;
function click(client, selector, scale) {
    return __awaiter(this, void 0, void 0, function () {
        var clientRect, Input, options;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0: return [4 /*yield*/, getClientRect(client, selector)];
                case 1:
                    clientRect = _a.sent();
                    Input = client.Input;
                    options = {
                        x: Math.round((clientRect.left + clientRect.width / 2) * scale),
                        y: Math.round((clientRect.top + clientRect.height / 2) * scale),
                        button: 'left',
                        clickCount: 1,
                    };
                    return [4 /*yield*/, Input.dispatchMouseEvent(__assign({}, options, { type: 'mousePressed' }))];
                case 2:
                    _a.sent();
                    return [4 /*yield*/, Input.dispatchMouseEvent(__assign({}, options, { type: 'mouseReleased' }))];
                case 3:
                    _a.sent();
                    return [2 /*return*/];
            }
        });
    });
}
exports.click = click;
function focus(client, selector) {
    return __awaiter(this, void 0, void 0, function () {
        var DOM, dom, node;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    DOM = client.DOM;
                    return [4 /*yield*/, DOM.getDocument()];
                case 1:
                    dom = _a.sent();
                    return [4 /*yield*/, DOM.querySelector({
                            nodeId: dom.root.nodeId,
                            selector: selector,
                        })];
                case 2:
                    node = _a.sent();
                    return [4 /*yield*/, DOM.focus(node)];
                case 3:
                    _a.sent();
                    return [2 /*return*/];
            }
        });
    });
}
exports.focus = focus;
function evaluate(client, fn) {
    var args = [];
    for (var _i = 2; _i < arguments.length; _i++) {
        args[_i - 2] = arguments[_i];
    }
    return __awaiter(this, void 0, void 0, function () {
        var Runtime, jsonArgs, argStr, expression, result;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    Runtime = client.Runtime;
                    jsonArgs = JSON.stringify(args);
                    argStr = jsonArgs.substr(1, jsonArgs.length - 2);
                    expression = "\n    (() => {\n      const expressionResult = (" + fn + ")(" + argStr + ");\n      if (expressionResult && expressionResult.then) {\n        expressionResult.catch((error) => { throw new Error(error); });\n        return expressionResult;\n      }\n      return Promise.resolve(expressionResult);\n    })();\n  ";
                    return [4 /*yield*/, Runtime.evaluate({
                            expression: expression,
                            returnByValue: true,
                            awaitPromise: true,
                        })];
                case 1:
                    result = _a.sent();
                    if (result && result.exceptionDetails) {
                        throw new Error(result.exceptionDetails.exception.value ||
                            result.exceptionDetails.exception.description);
                    }
                    if (result && result.result) {
                        return [2 /*return*/, result.result.value];
                    }
                    return [2 /*return*/, null];
            }
        });
    });
}
exports.evaluate = evaluate;
function type(client, text, selector) {
    return __awaiter(this, void 0, void 0, function () {
        var Input, i, char, options;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    if (!selector) return [3 /*break*/, 3];
                    return [4 /*yield*/, focus(client, selector)];
                case 1:
                    _a.sent();
                    return [4 /*yield*/, wait(500)];
                case 2:
                    _a.sent();
                    _a.label = 3;
                case 3:
                    Input = client.Input;
                    i = 0;
                    _a.label = 4;
                case 4:
                    if (!(i < text.length)) return [3 /*break*/, 7];
                    char = text[i];
                    options = {
                        type: 'char',
                        text: char,
                        unmodifiedText: char,
                    };
                    return [4 /*yield*/, Input.dispatchKeyEvent(options)];
                case 5:
                    _a.sent();
                    _a.label = 6;
                case 6:
                    i++;
                    return [3 /*break*/, 4];
                case 7: return [2 /*return*/];
            }
        });
    });
}
exports.type = type;
function press(client, keyCode, count, modifiers) {
    return __awaiter(this, void 0, void 0, function () {
        var Input, options, i;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    Input = client.Input;
                    if (count === undefined) {
                        count = 1;
                    }
                    options = {
                        nativeVirtualKeyCode: keyCode,
                        windowsVirtualKeyCode: keyCode,
                    };
                    if (modifiers) {
                        options['modifiers'] = modifiers;
                    }
                    i = 0;
                    _a.label = 1;
                case 1:
                    if (!(i < count)) return [3 /*break*/, 5];
                    return [4 /*yield*/, Input.dispatchKeyEvent(__assign({}, options, { type: 'rawKeyDown' }))];
                case 2:
                    _a.sent();
                    return [4 /*yield*/, Input.dispatchKeyEvent(__assign({}, options, { type: 'keyUp' }))];
                case 3:
                    _a.sent();
                    _a.label = 4;
                case 4:
                    i++;
                    return [3 /*break*/, 1];
                case 5: return [2 /*return*/];
            }
        });
    });
}
exports.press = press;
function getValue(client, selector) {
    return __awaiter(this, void 0, void 0, function () {
        var Runtime, browserCode, expression, result;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    Runtime = client.Runtime;
                    browserCode = function (selector) {
                        return document.querySelector(selector).value;
                    };
                    expression = "(" + browserCode + ")(`" + selector + "`)";
                    return [4 /*yield*/, Runtime.evaluate({
                            expression: expression,
                        })];
                case 1:
                    result = _a.sent();
                    return [2 /*return*/, result.result.value];
            }
        });
    });
}
exports.getValue = getValue;
function scrollTo(client, x, y) {
    return __awaiter(this, void 0, void 0, function () {
        var Runtime, browserCode, expression;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    Runtime = client.Runtime;
                    browserCode = function (x, y) {
                        return window.scrollTo(x, y);
                    };
                    expression = "(" + browserCode + ")(" + x + ", " + y + ")";
                    return [4 /*yield*/, Runtime.evaluate({
                            expression: expression,
                        })];
                case 1:
                    _a.sent();
                    return [2 /*return*/];
            }
        });
    });
}
exports.scrollTo = scrollTo;
function scrollToElement(client, selector) {
    return __awaiter(this, void 0, void 0, function () {
        var clientRect;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0: return [4 /*yield*/, getClientRect(client, selector)];
                case 1:
                    clientRect = _a.sent();
                    return [2 /*return*/, scrollTo(client, clientRect.left, clientRect.top)];
            }
        });
    });
}
exports.scrollToElement = scrollToElement;
function setHtml(client, html) {
    return __awaiter(this, void 0, void 0, function () {
        var Page, frameId;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    Page = client.Page;
                    return [4 /*yield*/, Page.getResourceTree()];
                case 1:
                    frameId = (_a.sent()).frameTree.frame.id;
                    return [4 /*yield*/, Page.setDocumentContent({ frameId: frameId, html: html })];
                case 2:
                    _a.sent();
                    return [2 /*return*/];
            }
        });
    });
}
exports.setHtml = setHtml;
function getCookies(client, nameOrQuery) {
    return __awaiter(this, void 0, void 0, function () {
        var Network, fn, url, result, cookies, filteredCookies;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    Network = client.Network;
                    fn = function () { return location.href; };
                    return [4 /*yield*/, evaluate(client, "" + fn)];
                case 1:
                    url = (_a.sent());
                    return [4 /*yield*/, Network.getCookies([url])];
                case 2:
                    result = _a.sent();
                    cookies = result.cookies;
                    if (typeof nameOrQuery !== 'undefined' && typeof nameOrQuery === 'string') {
                        filteredCookies = cookies.filter(function (cookie) { return cookie.name === nameOrQuery; });
                        return [2 /*return*/, filteredCookies];
                    }
                    return [2 /*return*/, cookies];
            }
        });
    });
}
exports.getCookies = getCookies;
function getAllCookies(client) {
    return __awaiter(this, void 0, void 0, function () {
        var Network, result;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    Network = client.Network;
                    return [4 /*yield*/, Network.getAllCookies()];
                case 1:
                    result = _a.sent();
                    return [2 /*return*/, result.cookies];
            }
        });
    });
}
exports.getAllCookies = getAllCookies;
function setCookies(client, cookies) {
    return __awaiter(this, void 0, void 0, function () {
        var Network, _i, cookies_1, cookie;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    Network = client.Network;
                    _i = 0, cookies_1 = cookies;
                    _a.label = 1;
                case 1:
                    if (!(_i < cookies_1.length)) return [3 /*break*/, 4];
                    cookie = cookies_1[_i];
                    return [4 /*yield*/, Network.setCookie(__assign({}, cookie, { url: getUrlFromCookie(cookie) }))];
                case 2:
                    _a.sent();
                    _a.label = 3;
                case 3:
                    _i++;
                    return [3 /*break*/, 1];
                case 4: return [2 /*return*/];
            }
        });
    });
}
exports.setCookies = setCookies;
function mousedown(client, selector, scale) {
    return __awaiter(this, void 0, void 0, function () {
        var clientRect, Input, options;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0: return [4 /*yield*/, getClientRect(client, selector)];
                case 1:
                    clientRect = _a.sent();
                    Input = client.Input;
                    options = {
                        x: Math.round((clientRect.left + clientRect.width / 2) * scale),
                        y: Math.round((clientRect.top + clientRect.height / 2) * scale),
                        button: 'left',
                        clickCount: 1,
                    };
                    return [4 /*yield*/, Input.dispatchMouseEvent(__assign({}, options, { type: 'mousePressed' }))];
                case 2:
                    _a.sent();
                    return [2 /*return*/];
            }
        });
    });
}
exports.mousedown = mousedown;
function mouseup(client, selector, scale) {
    return __awaiter(this, void 0, void 0, function () {
        var clientRect, Input, options;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0: return [4 /*yield*/, getClientRect(client, selector)];
                case 1:
                    clientRect = _a.sent();
                    Input = client.Input;
                    options = {
                        x: Math.round((clientRect.left + clientRect.width / 2) * scale),
                        y: Math.round((clientRect.top + clientRect.height / 2) * scale),
                        button: 'left',
                        clickCount: 1,
                    };
                    return [4 /*yield*/, Input.dispatchMouseEvent(__assign({}, options, { type: 'mouseReleased' }))];
                case 2:
                    _a.sent();
                    return [2 /*return*/];
            }
        });
    });
}
exports.mouseup = mouseup;
function getUrlFromCookie(cookie) {
    var domain = cookie.domain.slice(1, cookie.domain.length);
    return "https://" + domain;
}
function deleteCookie(client, name, url) {
    return __awaiter(this, void 0, void 0, function () {
        var Network;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    Network = client.Network;
                    return [4 /*yield*/, Network.deleteCookie({ cookieName: name, url: url })];
                case 1:
                    _a.sent();
                    return [2 /*return*/];
            }
        });
    });
}
exports.deleteCookie = deleteCookie;
function clearCookies(client) {
    return __awaiter(this, void 0, void 0, function () {
        var Network;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    Network = client.Network;
                    return [4 /*yield*/, Network.clearBrowserCookies()];
                case 1:
                    _a.sent();
                    return [2 /*return*/];
            }
        });
    });
}
exports.clearCookies = clearCookies;
function screenshot(client) {
    return __awaiter(this, void 0, void 0, function () {
        var Page, screenshot;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    Page = client.Page;
                    return [4 /*yield*/, Page.captureScreenshot({ format: 'png' })];
                case 1:
                    screenshot = _a.sent();
                    return [2 /*return*/, screenshot.data];
            }
        });
    });
}
exports.screenshot = screenshot;
function html(client) {
    return __awaiter(this, void 0, void 0, function () {
        var DOM, nodeId, outerHTML;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    DOM = client.DOM;
                    return [4 /*yield*/, DOM.getDocument()];
                case 1:
                    nodeId = (_a.sent()).root.nodeId;
                    return [4 /*yield*/, DOM.getOuterHTML({ nodeId: nodeId })];
                case 2:
                    outerHTML = (_a.sent()).outerHTML;
                    return [2 /*return*/, outerHTML];
            }
        });
    });
}
exports.html = html;
function pdf(client, options) {
    return __awaiter(this, void 0, void 0, function () {
        var Page, pdf;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    Page = client.Page;
                    return [4 /*yield*/, Page.printToPDF(options)];
                case 1:
                    pdf = _a.sent();
                    return [2 /*return*/, pdf.data];
            }
        });
    });
}
exports.pdf = pdf;
function clearInput(client, selector) {
    return __awaiter(this, void 0, void 0, function () {
        var Input, text, optionsDelete, optionsBackspace, i;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0: return [4 /*yield*/, wait(500)];
                case 1:
                    _a.sent();
                    return [4 /*yield*/, focus(client, selector)];
                case 2:
                    _a.sent();
                    Input = client.Input;
                    return [4 /*yield*/, getValue(client, selector)];
                case 3:
                    text = _a.sent();
                    optionsDelete = {
                        nativeVirtualKeyCode: 46,
                        windowsVirtualKeyCode: 46,
                    };
                    optionsBackspace = {
                        nativeVirtualKeyCode: 8,
                        windowsVirtualKeyCode: 8,
                    };
                    i = 0;
                    _a.label = 4;
                case 4:
                    if (!(i < text.length)) return [3 /*break*/, 8];
                    return [4 /*yield*/, Input.dispatchKeyEvent(__assign({}, optionsDelete, { type: 'rawKeyDown' }))];
                case 5:
                    _a.sent();
                    Input.dispatchKeyEvent(__assign({}, optionsDelete, { type: 'keyUp' }));
                    return [4 /*yield*/, Input.dispatchKeyEvent(__assign({}, optionsBackspace, { type: 'rawKeyDown' }))];
                case 6:
                    _a.sent();
                    Input.dispatchKeyEvent(__assign({}, optionsBackspace, { type: 'keyUp' }));
                    _a.label = 7;
                case 7:
                    i++;
                    return [3 /*break*/, 4];
                case 8: return [2 /*return*/];
            }
        });
    });
}
exports.clearInput = clearInput;
function setFileInput(client, selector, files) {
    return __awaiter(this, void 0, void 0, function () {
        var DOM, dom, node;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    DOM = client.DOM;
                    return [4 /*yield*/, DOM.getDocument()];
                case 1:
                    dom = _a.sent();
                    return [4 /*yield*/, DOM.querySelector({
                            nodeId: dom.root.nodeId,
                            selector: selector,
                        })];
                case 2:
                    node = _a.sent();
                    return [4 /*yield*/, DOM.setFileInputFiles({ files: files, nodeId: node.nodeId })];
                case 3: return [2 /*return*/, _a.sent()];
            }
        });
    });
}
exports.setFileInput = setFileInput;
function getDebugOption() {
    if (process &&
        process.env &&
        process.env['DEBUG'] &&
        process.env['DEBUG'].includes('chromeless')) {
        return true;
    }
    return false;
}
exports.getDebugOption = getDebugOption;
//# sourceMappingURL=util.js.map