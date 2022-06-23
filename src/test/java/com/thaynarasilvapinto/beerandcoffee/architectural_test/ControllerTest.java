package com.thaynarasilvapinto.beerandcoffee.architectural_test;

import com.thaynarasilvapinto.beerandcoffee.architectural_test.config.PackageEnum;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import java.util.Set;

@AnalyzeClasses(packages = "com.thaynarasilvapinto.beerandcoffee")
public class ControllerTest {

    @ArchTest
    static ArchRule class_controller_must_be_package_controller =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameEndingWith("Controller")
                    .should()
                    .resideInAnyPackage(PackageEnum.CONTROLLER.getDescription());

    @ArchTest
    static ArchRule class_use_case_must_have_the_name_cotroller =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.CONTROLLER.getDescription())
                    .should()
                    .haveSimpleNameEndingWith("Controller");

    @ArchTest
    static ArchRule class_controller_should_not_be_a_interface =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.CONTROLLER.getDescription())
                    .should()
                    .notBeInterfaces();

    @ArchTest
    static ArchRule class_controller_annotation_with_controller =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.CONTROLLER.getDescription())
                    .should()
                    .beAnnotatedWith(RestController.class)
                    .andShould()
                    .beAnnotatedWith(RequestMapping.class);

    @ArchTest
    static ArchRule class_use_case_impl_should_not_be_annotations =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.CONTROLLER.getDescription())
                    .should()
                    .notBeAnnotatedWith(Component.class)
                    .andShould().
                    notBeAnnotatedWith(Entity.class)
                    .andShould().
                    notBeAnnotatedWith(Repository.class)
                    .andShould().
                    notBeAnnotatedWith(Service.class)
                    .andShould().
                    notBeAnnotatedWith(Controller.class);


    @ArchTest
    static ArchRule custom_role =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.CONTROLLER.getDescription())
                    .should(containsSpecificMethod("create"));

    private static ArchCondition<JavaClass> containsSpecificMethod(String methodName){
        return new ArchCondition<JavaClass>("Must contain a specific method") {
            @Override
            public void check(JavaClass javaClass, ConditionEvents conditionEvents) {
                final String name = javaClass.getName();
                final Set<JavaMethod> methods = javaClass.getMethods();
                boolean hasMethod = false;

                for (JavaMethod method: methods) {
                    if(method.getName().equals(methodName)){
                        hasMethod = true;
                    }
                }

                if(!hasMethod){
                    throw new AssertionError(String.format("Class %s does not have the %s method", name, methodName));
                }
            }
        };
    }
}
