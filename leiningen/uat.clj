(ns leiningen.uat
	(use [leiningen.core :only [dev-appserver kill-appserver]]))

(defn uat [project & args]
	(dev-appserver)
	(test project)
	(kill-appserver))
