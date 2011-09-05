(ns leiningen.uat
	(use [leiningen.gae :only [dev-appserver kill-appserver]]
			 [leiningen.midje]))

(defn uat [project & args]
	(dev-appserver project)
	(midje project "endtoend.beget-test")
	(kill-appserver))
