//
//  FPFun.m
//  objectivec.playground
//
//  Created by Dev on 4/22/14.
//  Copyright (c) 2014 Dev. All rights reserved.
//

#import "FPFun.h"
#import <Functional.IOS/F.h>
#import <Functional.IOS/NSArray+F.h>
#import <Functional.IOS/NSDictionary+F.h>
#import <Functional.IOS/NSNumber+F.h>

@implementation FPFun
-(void) doFunFP{
    
    NSArray *numberArray = [NSArray arrayFrom:1 To:5];
    NSArray *numberNamesArray = [NSArray arrayWithObjects:@"one", @"two", @"three", @"four", @"five", nil];
    NSDictionary *numberDict = [NSDictionary dictionaryWithObjects:numberArray forKeys:numberNamesArray];
    
    [numberArray each:^(id obj) {
        NSLog(@"Current Object : %@", obj);
    }];
    
    NSLog(@"%@",numberDict);

}
@end
