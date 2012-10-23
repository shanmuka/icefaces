package org.icefaces.samples.showcase.example.ace.chart;

import org.icefaces.ace.model.chart.GaugeSeries;
import org.icefaces.samples.showcase.metadata.annotation.ComponentExample;
import org.icefaces.samples.showcase.metadata.annotation.ExampleResource;
import org.icefaces.samples.showcase.metadata.annotation.ExampleResources;
import org.icefaces.samples.showcase.metadata.annotation.ResourceType;
import org.icefaces.samples.showcase.metadata.context.ComponentExampleImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ComponentExample(
        parent = ChartBean.BEAN_NAME,
        title = "example.ace.chart.gauge.title",
        description = "example.ace.chart.gauge.description",
        example = "/resources/examples/ace/chart/chartGauge.xhtml"
)
@ExampleResources(
        resources ={
                // xhtml
                @ExampleResource(type = ResourceType.xhtml,
                        title="ChartGauge.xhtml",
                        resource = "/resources/examples/ace/chart/chartGauge.xhtml"),
                // Java Source
                @ExampleResource(type = ResourceType.java,
                        title="ChartGaugeBean.java",
                        resource = "/WEB-INF/classes/org/icefaces/samples/showcase/example/ace/chart/ChartGaugeBean.java")
        }
)
@ManagedBean(name= ChartGaugeBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class ChartGaugeBean extends ComponentExampleImpl<ChartGaugeBean> implements Serializable {
    public static final String BEAN_NAME = "chartGaugeBean";

    public List<GaugeSeries> gaugeData = new ArrayList<GaugeSeries>() {{
        add(new GaugeSeries(5) {{
            setMin(0);
            setMax(10);
        }});
    }};

    public List<GaugeSeries> getGaugeData() {
        return gaugeData;
    }

    public void setGaugeData(List<GaugeSeries> gaugeData) {
        this.gaugeData = gaugeData;
    }

    public ChartGaugeBean() {
        super(ChartGaugeBean.class);
    }

    @PostConstruct
    public void initMetaData() {
        super.initMetaData();
    }
}
