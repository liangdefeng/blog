package com.spel.blog.service;

import com.google.common.base.Joiner;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.builder.Extension;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service(MarkdownToHtmlService.NAME)
public class MarkdownToHtmlServiceBean implements MarkdownToHtmlService {

    public String convert(String markDown) {

        BufferedReader reader = new BufferedReader(new StringReader(markDown));
        List<String> list = reader.lines().collect(Collectors.toList());
        String content = Joiner.on("\n").join(list);

        // markdown to image
        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);
        options.set(Parser.EXTENSIONS, Arrays.asList(new Extension[] { TablesExtension.create()}));
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        return renderer.render(parser.parse(content));
    }
}