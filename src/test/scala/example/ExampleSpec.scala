package example

import example._04_genericMetamodel.Ex_01_Grouping
import example._05_relationships._
import example._09_application._
import example._08_business._
import example._06_motivation._
import example._07_strategy._
import org.scalatest.FunSpec

class ExampleSpec extends FunSpec {

	describe("4. generic metamodel") {
		describe("Ex_01_Grouping") {
			it("should run without errors") {
				Ex_01_Grouping.main(Array())
			}
		}
	}

	describe("5. relationships") {
		describe("Ex_02_Composition") {
			it("should run without errors") {
				Ex_02_Composition.main(Array())
			}
		}
		describe("Ex_03_Aggregation") {
			it("should run without errors") {
				Ex_03_Aggregation.main(Array())
			}
		}
		describe("Ex_04_Assignment") {
			it("should run without errors") {
				Ex_04_Assignment.main(Array())
			}
		}
		describe("Ex_05_Realization") {
			it("should run without errors") {
				Ex_05_Realization.main(Array())
			}
		}
		describe("Ex_06_Serving") {
			it("should run without errors") {
				Ex_06_Serving.main(Array())
			}
		}
		describe("Ex_07_Serving") {
			it("should run without errors") {
				Ex_07_Access.main(Array())
			}
		}
		describe("Ex_08_Influence") {
			it("should run without errors") {
				Ex_08_Influence.main(Array())
			}
		}
		describe("Ex_09_Triggering") {
			it("should run without errors") {
				Ex_09_Triggering.main(Array())
			}
		}
		describe("Ex_10_Flow") {
			it("should run without errors") {
				Ex_10_Flow.main(Array())
			}
		}
		describe("Ex_11_Specialization") {
			it("should run without errors") {
				Ex_11_Specialization.main(Array())
			}
		}
		describe("Ex_12_Association") {
			it("should run without errors") {
				Ex_12_Association.main(Array())
			}
		}
		describe("Ex_13_AndJunction") {
			it("should run without errors") {
				Ex_13_AndJunction.main(Array())
			}
		}
		describe("Ex_14_OrJunction") {
			it("should run without errors") {
				Ex_14_OrJunction.main(Array())
			}
		}
		describe("Ex_15_DerivedStructuralAndDependencyRelationship") {
			it("should run without errors") {
				Ex_15_DerivedStructuralAndDependencyRelationship.main(Array())
			}
		}
		describe("Ex_16_DerivedFlowRelationships") {
			it("should run without errors") {
				Ex_16_DerivedFlowRelationships.main(Array())
			}
		}
		describe("Ex_17_DerivedTriggeringRelationships") {
			it("should run without errors") {
				Ex_17_DerivedTriggeringRelationships.main(Array())
			}
		}
	}

	describe("6. motivation") {
		describe("Ex_18_StakeholderDriverAndAssessment") {
			it("should run without errors") {
				Ex_18_StakeholderDriverAndAssessment.main(Array())
			}
		}
		describe("Ex_19_GoalOutcomePrincipleRequirementAndConstraint") {
			it("should run without errors") {
				Ex_19_GoalOutcomePrincipleRequirementAndConstraint.main(Array())
			}
		}
		describe("Ex_20_MeaningAndValue") {
			it("should run without errors") {
				Ex_20_MeaningAndValue.main(Array())
			}
		}
	}

	describe("7. strategy") {
		describe("Ex_21_StrategyElements") {
			it("should run without errors") {
				Ex_21_StrategyElements.main(Array())
			}
		}
	}

	describe("8. business") {
		describe("Ex_22_BusinessActiveStructureElements") {
			it("should run without errors") {
				Ex_22_BusinessActiveStructureElements.main(Array())
			}
		}
		describe("Ex_23_BusinessBehaviorElements") {
			it("should run without errors") {
				Ex_23_BusinessBehaviorElements.main(Array())
			}
		}
		describe("Ex_24_BusinessPassiveStructureElements") {
			it("should run without errors") {
				Ex_24_BusinessPassiveStructureElements.main(Array())
			}
		}
		describe("Ex_25_BusinessCompositeElementProduct") {
			it("should run without errors") {
				Ex_25_BusinessCompositeElementProduct.main(Array())
			}
		}
	}

	describe("9. application") {
		describe("Ex_18_StakeholderDriverAndAssessment") {
			it("should run without errors") {
				Ex_26_ApplicationActiveStructureElements.main(Array())
			}
		}
		describe("Ex_27_ApplicationBehaviorElements") {
			it("should run without errors") {
				Ex_27_ApplicationBehaviorElements.main(Array())
			}
		}
		describe("Ex_28_ApplicationPassiveStructureElements") {
			it("should run without errors") {
				Ex_28_ApplicationPassiveStructureElements.main(Array())
			}
		}
	}
}
