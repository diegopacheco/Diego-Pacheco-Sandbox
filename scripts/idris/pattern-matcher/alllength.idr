allLengths : List String -> List Nat
allLengths [] = []
allLengths strs = map length strs
