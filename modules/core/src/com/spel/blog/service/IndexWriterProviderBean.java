package com.spel.blog.service;

import com.haulmont.fts.core.sys.EntityAttributeAnalyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.miscellaneous.PerFieldAnalyzerWrapper;

import java.util.HashMap;
import java.util.Map;

import static com.haulmont.fts.core.sys.LuceneConstants.FLD_LINKS;
import static com.haulmont.fts.core.sys.LuceneConstants.FLD_MORPHOLOGY_ALL;

public class IndexWriterProviderBean extends com.haulmont.fts.core.sys.IndexWriterProviderBean {

    @Override
    protected Analyzer createAnalyzer() {
        Map<String, Analyzer> analyzerPerField = new HashMap<>();
        analyzerPerField.put(FLD_LINKS, new WhitespaceAnalyzer());
        analyzerPerField.put(FLD_MORPHOLOGY_ALL, new SmartChineseAnalyzer());
        return new PerFieldAnalyzerWrapper(new EntityAttributeAnalyzer(), analyzerPerField);
    }
}
