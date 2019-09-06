(ns thirty-days-code.sort-names-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [thirty-days-code.sort-names :refer :all]))

(def expected (str (clojure.string/join "\n" ["julia" "julia" "riya" "samantha" "tanya"]) "\n"))
(deftest sort-names-test
  (testing "given list of name and email, sort names of @gmail.com"
    (with-open [rdr (io/reader (io/resource "test-data/sort-names.txt"))]
      (binding [*in* rdr]
        (let [result (with-out-str (sort-names))]
          (is (= expected result)))))))

(run-tests)
