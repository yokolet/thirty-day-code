;; https://www.hackerrank.com/challenges/30-dictionaries-and-maps/problem

(ns thirty-days-code.phone-number)

(defn phone-number []
  (let [n (Integer/parseInt (clojure.string/trim (read-line)))
        book (reduce (fn [acc line]
                       (let [l (clojure.string/trim line)
                             [k v] (clojure.string/split l #"\s+")]
                         (assoc acc k (str k "=" v))))
                     {}
                     (repeatedly n #(read-line)))]
    (doseq [q (line-seq (java.io.BufferedReader. *in*))]
      (println (get book q "Not found")))))

