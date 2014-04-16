//
//  OOAdvanced.m
//  objectivec.playground
//
//  Created by Dev on 4/16/14.
//  Copyright (c) 2014 Dev. All rights reserved.
//

#import "OOAdvanced.h"

@implementation OOAdvanced

- (OOAdvanced *) init {
    _count = @1;
    _age = @29;
    return [super init];
}

- (void) doItAll {
    NSLog(@"OO -> %@ %@",_count, _age);
}

@end
