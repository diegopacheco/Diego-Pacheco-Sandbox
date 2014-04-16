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

- (OOAdvanced *) initReflection{
    OOAdvanced *o = [[[self class] alloc] init];
    return o;
}

- (OOAdvanced *) copyWithZone:(NSZone *)zone{
    OOAdvanced *ooa = [[OOAdvanced allocWithZone:zone] init];
    return ooa;
}

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wundeclared-selector"

- (void) doItSelectorUsage{
    if([self respondsToSelector:@selector(thisMessageDoesNotExist)]){
        NSLog(@"Yup, OOAdvanced responds to the thisMessageDoesNotExist message");
    }else{
        NSLog(@"Nope, OOAdvanced DOES NOT respond to the thisMessageDoesNotExist message");
    }
}

#pragma clang diagnostic pop

- (void) doWorkWithNil{
    OOAdvanced *ooa = [[OOAdvanced alloc] init];
    ooa.name = nil;
    if (ooa.name){
        NSLog(@"%@ is not nil", ooa.name);
    } else {
        NSLog(@"Sorry %@.name is nil", ooa.self);
    }
}

- (void) doItAll {
    
    // Using _(self variable) and instance variables
    NSLog(@"OO -> %@ %@",_count, _age);
    
    // Testing @selectors to know if i can call a method(send a message) or not
    [self doItSelectorUsage];
    
    // Reference copying using NSCopying protocol
    OOAdvanced *ooa = [[OOAdvanced alloc] init];
    OOAdvanced *copy = [ooa copy];
    NSLog(@"%@ - %@",ooa,copy);
    
    // Test nil with ifs
    [self doWorkWithNil];
    
    // Do some kind of copy/reflection
    NSLog(@"%@ init with some reflection", [ooa initReflection] );
}

@end
