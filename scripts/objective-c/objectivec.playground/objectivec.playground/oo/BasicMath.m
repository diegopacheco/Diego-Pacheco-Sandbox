//
//  BasicMath.m
//  objectivec_cli_playground
//
//  Created by Dev on 4/12/14.
//  Copyright (c) 2014 Dev. All rights reserved.
//

#import "BasicMath.h"

@implementation BasicMath

- (NSNumber *)pow:(NSNumber *)a {
    return @(a.doubleValue * a.doubleValue);
}

- (NSNumber *)sum:(NSNumber *)a : (NSNumber *)b {
    return @(a.doubleValue + b.doubleValue);
}

- (NSNumber *)subA:(NSNumber *)a b: (NSNumber *)b{
    return @(a.doubleValue - b.doubleValue);
}

- (NSNumber *)div:(NSNumber *)a : (NSNumber *)b {
    return @( a.doubleValue / b.doubleValue );
}

- (void)doItAll {
    BasicMath *math = [[BasicMath alloc] init];
    NSLog(@"pow: %@",  [math pow:[NSNumber numberWithInt:(int)10]]);
    NSLog(@"Sum: %@",  [math sum :@10 :@20]);
    NSLog(@"Sub: %@",  [math subA:@10 b:@5]);
    NSLog(@"Div: %@",  [math div :@500 :@10]);
    NSLog(@"FODA-SE");
}


@end