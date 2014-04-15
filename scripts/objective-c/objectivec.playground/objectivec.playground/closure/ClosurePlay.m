//
//  ClosurePlay.m
//  objectivec.playground
//
//  Created by Dev on 4/15/14.
//  Copyright (c) 2014 Dev. All rights reserved.
//

#import "ClosurePlay.h"

@implementation ClosurePlay

-(void) doFunWithClosure{
    void (^myBlock)(void) = ^{
        NSLog(@"Hello from inside the block");
    };
    
    myBlock();
    myBlock();
    myBlock();
    
    NSUInteger (^sumNumbers)(NSUInteger, NSUInteger) = ^(NSUInteger num1, NSUInteger num2){
        NSLog(@"The sum of the numbers is %lu", num1 + num2);
        return num1 + num2;
    };
    
    NSUInteger *result = sumNumbers(10,10);
    NSLog(@"%qi", result);
}

-(void) doClosureForFun{
    NSDictionary *cities = @{
        @"POA": @"Porto Alegre",
        @"GTI": @"Gravatai",
        @"CNH": @"Cachoeirinha",
        @"VIA": @"Viamao"
    };
    
    [cities enumerateKeysAndObjectsUsingBlock:^(id key, id obj, BOOL *stop) {
        NSLog(@"%@", cities[key]);
       }
    ];
}

-(void) doItAll{
    [self doFunWithClosure];
    [self doClosureForFun];
}
@end
