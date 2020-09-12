package io.github.fomin.oasgen.java.dto.jackson.annotated

import io.github.fomin.oasgen.JsonSchema
import io.github.fomin.oasgen.JsonType

class StringConverterMatcher : ConverterMatcher {
    override fun match(converterRegistry: ConverterRegistry, jsonSchema: JsonSchema): Converter? {
        return when (jsonSchema.type) {
            is JsonType.Scalar.STRING -> object : Converter {
                override val jsonSchema = jsonSchema
                override fun valueType() = "java.lang.String"
                override fun extraAnnotations(): String? = null
                override fun stringParseExpression(valueExpression: String) = valueExpression;
                override fun stringWriteExpression(valueExpression: String) = valueExpression;
                override fun output() = ConverterOutput.EMPTY
            }
            else -> null
        }
    }
}
