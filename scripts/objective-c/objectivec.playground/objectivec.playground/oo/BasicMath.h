//
//  BasicMath.h
//  objectivec_cli_playground
//
//  Created by Dev on 4/12/14.
//  Copyright (c) 2014 Dev. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface BasicMath : NSObject

- (NSNumber *)pow:(NSNumber *)a;
- (NSNumber *)sum:(NSNumber *)a : (NSNumber *)b;
- (NSNumber *)subA:(NSNumber *)a b: (NSNumber *)b;
- (NSNumber *)div:(NSNumber *)a : (NSNumber *)b;
- (void)doItAll;

@end
