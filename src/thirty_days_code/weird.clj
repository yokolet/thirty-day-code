;; https://www.hackerrank.com/challenges/30-conditional-statements/problem

(ns thirty-days-code.weird)

(defn weird?
  "prints 'weird' if a condition meets"
  [x]
  (let [f1 (fn [x] (<= 2 x 5))
        f2 (fn [x] (< 20 x))]
    (if (and (even? x) (or (f1 x) (f2 x)))
      "Not Weird"
      "Weird")))
