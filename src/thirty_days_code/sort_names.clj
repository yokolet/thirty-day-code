;; https://www.hackerrank.com/challenges/30-regex-patterns/problem
(ns thirty-days-code.sort-names)

(defn sort-names []
  (let [n (Integer/parseInt (clojure.string/trim (read-line)))
        names (reduce (fn [acc line]
                       (let [l (clojure.string/trim line)
                             [n e] (clojure.string/split l #"\s")]
                         (if (clojure.string/ends-with? e "@gmail.com")
                           (conj acc n)
                           acc)))
                     []
                     (repeatedly n #(read-line)))
        names (sort names)]
    (doseq [n names]
      (println n))))

