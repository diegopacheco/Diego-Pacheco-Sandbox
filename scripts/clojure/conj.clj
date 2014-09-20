(def bands (ref #{:metallica :blacksabbath :ironmaiden}) )
(dosync (alter bands conj :slayer))
(println bands)