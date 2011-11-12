// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 11/11/2011 7:30:05 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   AbstractPropertyBindingResult.java

package org.springframework.validation;

import java.beans.PropertyEditor;

import org.springframework.beans.ConfigurablePropertyAccessor;
import org.springframework.beans.PropertyAccessorUtils;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.ConvertingPropertyEditorAdapter;
import org.springframework.util.Assert;

// Referenced classes of package org.springframework.validation:
//            AbstractBindingResult

public abstract class AbstractPropertyBindingResult extends AbstractBindingResult
{

    protected AbstractPropertyBindingResult(String objectName)
    {
        super(objectName);
    }

    public void initConversion(ConversionService conversionService)
    {
        Assert.notNull(conversionService, "ConversionService must not be null");
        this.conversionService = conversionService;
        getPropertyAccessor().setConversionService(conversionService);
    }

    public PropertyEditorRegistry getPropertyEditorRegistry()
    {
        return getPropertyAccessor();
    }

    protected String canonicalFieldName(String field)
    {
        return PropertyAccessorUtils.canonicalPropertyName(field);
    }

    public Class getFieldType(String field)
    {
        return getPropertyAccessor().getPropertyType(fixedField(field));
    }

    protected Object getActualFieldValue(String field)
    {
        return getPropertyAccessor().getPropertyValue(field);
    }

    protected Object formatFieldValue(String field, Object value)
    {
        String fixedField = fixedField(field);
        PropertyEditor customEditor = getCustomEditor(fixedField);
        if(customEditor != null)
        {
            customEditor.setValue(value);
            String textValue = customEditor.getAsText();
            if(textValue != null)
                return textValue;
        }
        if(conversionService != null)
        {
            TypeDescriptor fieldDesc = getPropertyAccessor().getPropertyTypeDescriptor(fixedField);
            TypeDescriptor strDesc = TypeDescriptor.valueOf(String.class);
            if(fieldDesc != null && conversionService.canConvert(fieldDesc, strDesc))
                return conversionService.convert(value, fieldDesc, strDesc);
        }
        return value;
    }

    protected PropertyEditor getCustomEditor(String fixedField)
    {
        Class targetType = getPropertyAccessor().getPropertyType(fixedField);
        PropertyEditor editor = getPropertyAccessor().findCustomEditor(targetType, fixedField);
        // if(editor == null)
        // editor = BeanUtils.findEditorByConvention(targetType);
        return editor;
    }

    public PropertyEditor findEditor(String field, Class valueType)
    {
        if(valueType == null)
            valueType = getFieldType(field);
        PropertyEditor editor = super.findEditor(field, valueType);
        if(editor == null && conversionService != null)
        {
            TypeDescriptor td = field == null ? TypeDescriptor.valueOf(valueType) : getPropertyAccessor().getPropertyTypeDescriptor(fixedField(field));
            if(conversionService.canConvert(TypeDescriptor.valueOf(String.class), td))
                editor = new ConvertingPropertyEditorAdapter(conversionService, td);
        }
        return editor;
    }

    public abstract ConfigurablePropertyAccessor getPropertyAccessor();

    private ConversionService conversionService;
}
