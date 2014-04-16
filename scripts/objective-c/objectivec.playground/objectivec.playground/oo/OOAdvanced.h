//
//  OOAdvanced.h
//  objectivec.playground
//
//  Created by Dev on 4/16/14.
//  Copyright (c) 2014 Dev. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface OOAdvanced : NSObject {
    NSNumber *_count;
}

@property NSString *name;
@property (readonly) NSNumber *age;

- (void) doItAll;

@end
