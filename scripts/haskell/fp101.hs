last2 xs = head (drop (length xs -1) xs)

last3 xs = tail (reverse xs)

last4 xs = xs !! (length xs -1)

last5 xs = head (reverse xs)

last6 xs = reverse xs !! (length xs -1)

