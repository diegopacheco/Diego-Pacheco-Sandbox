//
//  DataTypes.m
//  objectivec.playground
//
//  Created by Dev on 4/15/14.
//  Copyright (c) 2014 Dev. All rights reserved.
//

#import "DataTypes.h"

@implementation DataTypes

-(void) doDictionary{
    NSDictionary *cities = @{
        @"POA": @"Porto Alegre",
        @"GTI": @"Gravatai",
        @"CNH": @"Cachoeirinha",
        @"VIA": @"Viamao"
    };
    NSLog(@"%@", cities);
    
    for (NSString *c in cities){
        NSString *desc = cities[c];
        NSLog(@"%@ is defined as %@", c, desc);
    }
}

-(void) doItAll{
    [self doDictionary];
}

@end
