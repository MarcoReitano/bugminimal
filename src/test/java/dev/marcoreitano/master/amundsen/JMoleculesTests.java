package dev.marcoreitano.master.amundsen;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.EvaluationResult;
import org.jmolecules.archunit.JMoleculesDddRules;

import static org.assertj.core.api.Assertions.assertThat;

@AnalyzeClasses(packages = "amundsen")
public class JMoleculesTests {

    @ArchTest
    void detectsViolations(JavaClasses classes) {

        EvaluationResult result = JMoleculesDddRules.all().evaluate(classes);

        assertThat(result.hasViolation()).isFalse();
    }
}
