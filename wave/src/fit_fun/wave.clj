;; A001006  Motzkin numbers: number of ways of drawing any number of
;;          nonintersecting chords joining n (labeled) points on a circle.

(ns fit-fun.wave)

(def wave
  (memoize
    (fn [x y]
      (cond
        (or (neg? y) (> y x)) 0
        (and (= x 0) (not= y 0)) 0
        (and (= x 0) (= y 0)) 1M
        :else (let [x' (dec x)]
                 (+ (wave x' y)
                    (wave x' (inc y))
                    (wave x' (dec y))))))))

(wave 4 0)
(wave 220 0)
(wave 420 0)

(map #(wave % 0) (range 50))