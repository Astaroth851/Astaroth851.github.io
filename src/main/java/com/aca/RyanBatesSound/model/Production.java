package com.aca.RyanBatesSound.model;

public enum Production {
		Short, Documentary, Feature, Commercial, Podcast, Concept, Corporate, ENG;

		public static Production convertStringToProduction(String value) {
			Production myProduction = null;
			for (Production production : Production.values()) {
				if (production.toString().equalsIgnoreCase(value)) {
					myProduction = production;
					break;
				}
			}
			return myProduction;
		}

	}


