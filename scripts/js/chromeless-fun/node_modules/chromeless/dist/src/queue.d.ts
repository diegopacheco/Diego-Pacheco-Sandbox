import { Chrome, Command } from './types';
export default class Queue {
    private flushCount;
    private commandQueue;
    private chrome;
    private lastWaitAll;
    constructor(chrome: Chrome);
    end(): Promise<void>;
    enqueue(command: Command): void;
    process<T extends any>(command: Command): Promise<T>;
    private waitAll();
}
