(defproject nz-ird-validator-clj "1.0.0"
  :description "A validator for New Zealand tax numbers (IRD)"
  :url "https://github.com/fnzc/nz-ird-validator-clj/FIXME"
  :author "Jeremy Farnault"
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :license {:name "MIT License"
            :url "https://github.com/fnzc/nz-ird-validator-clj/blob/master/LICENSE"}
  :target-path "target/%s"
  :signing {:gpg-key "02EEBEC3BBA039DDBE31A35C85759108682528DE"}
  :source-paths ["src"]
  :test-paths ["spec"]
  :deploy-repositories [["releases" :clojars]]
  :profiles {:uberjar {:aot :all}})
