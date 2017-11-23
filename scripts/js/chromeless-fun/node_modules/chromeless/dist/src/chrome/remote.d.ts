import { Chrome, ChromelessOptions, Command } from '../types';
export default class RemoteChrome implements Chrome {
    private options;
    private channelId;
    private channel;
    private connectionPromise;
    private TOPIC_NEW_SESSION;
    private TOPIC_CONNECTED;
    private TOPIC_REQUEST;
    private TOPIC_RESPONSE;
    private TOPIC_END;
    constructor(options: ChromelessOptions);
    private initConnection();
    process<T extends any>(command: Command): Promise<T>;
    close(): Promise<void>;
}
