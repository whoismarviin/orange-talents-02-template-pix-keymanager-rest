//package br.com.zup.edu.shared.validation
//
//
//import br.com.zup.edu.registraChave.
//import io.micronaut.core.annotation.AnnotationValue
//import io.micronaut.validation.validator.constraints.ConstraintValidator
//import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
//import javax.inject.Singleton
//import javax.validation.Constraint
//
//@MustBeDocumented
//@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
//@Retention(AnnotationRetention.RUNTIME)
//@Constraint(validatedBy = [ValidPixKeyValidator::class])
//annotation class ValidPixKey(val message: String = "Chave pix inválida (\${validatedValue.tipo})"){}
//
//
//@Singleton
//class ValidPixKeyValidator : ConstraintValidator<ValidPixKey, RegistraChaveRequest> {
//    override fun isValid(
//        value: RegistraChaveRequest,
//        annotationMetadata: AnnotationValue<ValidPixKey>,
//        context: ConstraintValidatorContext
//    ): Boolean {
//        if (value.tipoChave == null){
//            return false
//        }
//
//        return
//    }