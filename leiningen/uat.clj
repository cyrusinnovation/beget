(ns leiningen.uat
	(use [leiningen.server :only [dev-appserver kill-appserver]]
			 [leiningen.midje]))

(defn uat [project & args]
	(dev-appserver)
	(midje project "endtoend.beget-test")
	(kill-appserver))
