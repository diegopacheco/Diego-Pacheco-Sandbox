interface Calculator {
    sum(a:number,b:number):number;
}

export class SimpleCalculator{
    sum(a:number,b:number):number {
        return a+b;
    }
}