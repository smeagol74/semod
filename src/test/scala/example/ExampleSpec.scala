package example

import example.application.{Ex_26_ApplicationActiveStructureElements, Ex_27_ApplicationBehaviorElements, Ex_28_ApplicationPassiveStructureElements}
import example.business.{Ex_22_BusinessActiveStructureElements, Ex_23_BusinessBehaviorElements, Ex_24_BusinessPassiveStructureElements, Ex_25_BusinessCompositeElementProduct}
import example.motivation.{Ex_18_StakeholderDriverAndAssessment, Ex_19_GoalOutcomePrincipleRequirementAndConstraint, Ex_20_MeaningAndValue}
import example.strategy.Ex_21_StrategyElements
import org.scalatest.FunSpec

class ExampleSpec extends FunSpec {
	describe("motivation") {
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

	describe("strategy") {
		describe("Ex_21_StrategyElements") {
			it("should run without errors") {
				Ex_21_StrategyElements.main(Array())
			}
		}
	}

	describe("business") {
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

	describe("application") {
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
