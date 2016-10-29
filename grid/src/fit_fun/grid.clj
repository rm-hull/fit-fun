(ns fit-fun.grid)

(def grid
  (memoize
    (fn [m n]
      (cond
        (= m 0) 1
        (= n 0) 1
        :else (+ (grid (dec m) n) (grid m (dec n)))))))

(grid 5 4)
(grid 1 1)
(grid 0 0)