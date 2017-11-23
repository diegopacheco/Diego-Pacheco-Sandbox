import { ChromelessOptions, Cookie, CookieQuery, PdfOptions, DeviceMetrics } from './types';
export default class Chromeless<T extends any> implements Promise<T> {
    private queue;
    private lastReturnPromise;
    constructor(options?: ChromelessOptions, copyInstance?: Chromeless<any>);
    readonly [Symbol.toStringTag]: 'Promise';
    then<U>(onFulfill?: ((value: T) => U | PromiseLike<U>) | null, onReject?: ((error: any) => U | PromiseLike<U>) | null): Promise<U>;
    catch<U>(onrejected?: (reason: any) => U | PromiseLike<U>): Promise<U>;
    goto(url: string): Chromeless<T>;
    setUserAgent(useragent: string): Chromeless<T>;
    click(selector: string): Chromeless<T>;
    wait(timeout: number): Chromeless<T>;
    wait(selector: string, timeout?: number): Chromeless<T>;
    wait(fn: (...args: any[]) => boolean, ...args: any[]): Chromeless<T>;
    clearCache(): Chromeless<T>;
    focus(selector: string): Chromeless<T>;
    press(keyCode: number, count?: number, modifiers?: any): Chromeless<T>;
    type(input: string, selector?: string): Chromeless<T>;
    back(): Chromeless<T>;
    forward(): Chromeless<T>;
    refresh(): Chromeless<T>;
    mousedown(selector: string): Chromeless<T>;
    mouseup(selector: string): Chromeless<T>;
    mouseover(): Chromeless<T>;
    scrollTo(x: number, y: number): Chromeless<T>;
    scrollToElement(selector: string): Chromeless<T>;
    setViewport(options: DeviceMetrics): Chromeless<T>;
    setHtml(html: string): Chromeless<T>;
    evaluate<U extends any>(fn: (...args: any[]) => void, ...args: any[]): Chromeless<U>;
    inputValue(selector: string): Chromeless<string>;
    exists(selector: string): Chromeless<boolean>;
    screenshot(): Chromeless<string>;
    html(): Chromeless<string>;
    pdf(options?: PdfOptions): Chromeless<string>;
    /**
     * Get the cookies for the current url
     */
    cookies(): Chromeless<Cookie[] | null>;
    /**
     * Get a specific cookie for the current url
     * @param name
     */
    cookies(name: string): Chromeless<Cookie | null>;
    /**
     * Get a specific cookie by query. Not implemented yet
     * @param query
     */
    cookies(query: CookieQuery): Chromeless<Cookie[] | null>;
    allCookies(): Chromeless<Cookie[]>;
    setCookies(name: string, value: string): Chromeless<T>;
    setCookies(cookie: Cookie): Chromeless<T>;
    setCookies(cookies: Cookie[]): Chromeless<T>;
    deleteCookies(name: string, url: string): Chromeless<T>;
    clearCookies(): Chromeless<T>;
    clearInput(selector: string): Chromeless<T>;
    setFileInput(selector: string, files: string): Chromeless<T>;
    setFileInput(selector: string, files: string[]): Chromeless<T>;
    end(): Promise<T>;
}
