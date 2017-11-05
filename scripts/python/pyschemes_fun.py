from pyschemes import Scheme, validators
from collections import Iterable

print( str( Scheme(int).validate(10)  ))
print( str(  Scheme(Iterable).validate([1, 2]) ))
