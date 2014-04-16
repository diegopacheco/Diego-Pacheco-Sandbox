//
//  OOAdvanced.h
//  objectivec.playground
//
//  Created by Dev on 4/16/14.
//  Copyright (c) 2014 Dev. All rights reserved.
//

#import <Foundation/Foundation.h>

// NSCopying is a protocol
@interface OOAdvanced : NSObject <NSCopying>{
    // count is a instance variable
    NSNumber *_count;
}

- (OOAdvanced *) initReflection;

@property NSString *name;
@property (readonly) NSNumber *age;

- (void) doItAll;

@end
