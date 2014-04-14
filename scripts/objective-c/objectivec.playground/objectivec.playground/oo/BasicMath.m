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

@end