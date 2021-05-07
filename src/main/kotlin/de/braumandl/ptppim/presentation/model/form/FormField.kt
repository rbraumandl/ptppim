package de.braumandl.ptppim.presentation.model.form

/**
 * Generic class which represents a form field and which uses
 * overloaded operators for expressing conditions in validation
 * computations. Perhaps it is possible to use delegation for
 * accessing values of the parameterized types.
 *
 * A form field has an identifier to refer to this form field.
 * This identifier has to be unique within a form whereas the form
 * itself also has an identifier so that a hierarchical namespace is
 * generated also in the case of nested forms.
 *
 * Overloaded operators should be coded in a way that also the values
 * of the parameterized type can be used e.g. as values in comparisons.
 */
class FormField {
}