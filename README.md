# MolarMass
 A rather poorly made molar mass parser

Its an LL(1) Parser as follows
```
Formula -> Term + Formula
Formula -> ε
Term -> Value + Subscript
Value -> Formula
Value -> Element (H, He, ...)
Subscript -> Digit
Subscript -> ε
```

Its decently poorly coded but it works as far as I know