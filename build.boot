;; copyright (c) 2015-2016 Sean Corfield

(def version "1.0.11")

(set-env! :resource-paths #{"src"})

(task-options!
 pom {:project     'seancorfield/boot-expectations
      :version     version
      :description "Run some expectations in boot!"
      :url         "https://github.com/seancorfield/boot-expectations"
      :scm         {:url "https://github.com/seancorfield/boot-expectations"}
      :license     {"Eclipse Public License"
                    "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask build []
  (comp (pom) (jar) (install)))

(deftask deploy
  [g gpg-sign bool "Sign jar using GPG private key."]
  (comp (pom) (jar) (apply push (mapcat identity *opts*))))
