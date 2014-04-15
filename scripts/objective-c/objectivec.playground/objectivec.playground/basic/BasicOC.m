//
//  BasicOC.m
//  objectivec.playground
//
//  Created by Dev on 4/14/14.
//  Copyright (c) 2014 Dev. All rights reserved.
//

#import "BasicOC.h"

@implementation BasicOC

-(void) doIFBooleans {
    BOOL cool = YES;
    if(cool){
        NSLog(@"Oh yeah cool is: %@", ( cool ? @"YES" : @"NO" ) );
    }
}

-(void) doIsEqualStrings{
    NSString *a = @"Diego";
    NSString *b = @"Diego";
    if ( [a isEqualToString: b] ){
        NSLog(@" A(%@) == B(%@) ",a,b);
    } else {
        NSLog(@"A != B");
    }
}

-(void) doSwitch{
    NSCalendar *gregorian = [[NSCalendar alloc] initWithCalendarIdentifier:NSGregorianCalendar];
    NSDateComponents *comps = [gregorian components:NSWeekdayCalendarUnit fromDate:[NSDate date]];
    long weekday = [comps weekday];
    NSLog(@"Day of the Week %lu", weekday);
    
    switch (weekday) {
        case 1:
            NSLog(@"Domingo");
        break;
        case 2:
            NSLog(@"Segunda");
        break;
        case 3:
            NSLog(@"Terca");
        break;
        case 4:
            NSLog(@"Quarta");
        break;
        case 5:
            NSLog(@"Quinta");
        break;
        case 6:
            NSLog(@"Sexta");
        break;
        case 7:
            NSLog(@"Sabado");
        break;
        default:
            NSLog(@"WTF?");
        break;
    }
}

-(void) doArrays{
   NSArray *dayz = @[@"Segunda", @"Terca", @"Quarta"];
   NSLog(@"Day: %@", dayz[0]);
   NSLog(@"Day: %@", dayz[1]);
   NSLog(@"Day: %@", dayz[2]);
}

-(void) doForLoop{
    NSArray *dayz = @[@"Dia 1", @"Dia 2", @"Dia 3"];
    for (NSString *d in dayz) {
        NSLog(@"%@",d);
    }
}

-(void) doBasicStuff{
    [self doIFBooleans];
    [self doIsEqualStrings];
    [self doSwitch];
    [self doArrays];
    [self doForLoop];
}
@end
