(window.webpackJsonp=window.webpackJsonp||[]).push([[293],{1002:function(e,t,r){var n=r(221),o=r(900);e.exports=function(e,t){return n(o(e,t),1)}},1007:function(e,t,r){(e.exports=r(28)(!1)).push([e.i,".bar-chart-bar{fill:#4b9fd5}.bar-chart-tick{fill:#777;font-size:12px;text-anchor:middle}",""])},1008:function(e,t,r){var n=r(1007);"string"==typeof n&&(n=[[e.i,n,""]]);var o={hmr:!0,transform:void 0,insertInto:void 0};r(27)(n,o);n.locals&&(e.exports=n.locals)},1044:function(e,t,r){"use strict";var n,o=r(15),a=r(32),i=r.n(a),c=r(951),s=r.n(c),l=r(0),p=r(909),u=r(957),m=r(36),f=(r(1008),r(1065),n=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var r in t)t.hasOwnProperty(r)&&(e[r]=t[r])},function(e,t){function r(){this.constructor=e}n(e,t),e.prototype=null===t?Object.create(t):(r.prototype=t.prototype,new r)}),d=[10,10,10,10],h=function(e){function t(){return null!==e&&e.apply(this,arguments)||this}return f(t,e),t.prototype.renderBar=function(e,t,r,n){var o=this.props,a=o.alignTicks,i=o.padding,c=void 0===i?d:i,s=Math.round(r(e))+1,p=r.range()[0]+(a?c[3]:0),u=Math.round(n(t)+n.bandwidth()/2);return l.createElement("rect",{className:"bar-chart-bar",x:p,y:u,width:s,height:10})},t.prototype.renderValue=function(e,t,r,n){var o=this.props,a=o.alignTicks,i=o.padding,c=void 0===i?d:i,s=o.yValues,p=s&&s[t];if(!p)return null;var u=r(e)+(a?c[3]:0),f=Math.round(n(t)+n.bandwidth()/2+5);return l.createElement(m.a,{overlay:this.props.yTooltips&&this.props.yTooltips[t]},l.createElement("text",{className:"bar-chart-tick histogram-value",x:u,y:f,dx:"1em",dy:"0.3em"},p))},t.prototype.renderTick=function(e,t,r){var n=this.props,o=n.alignTicks,a=n.yTicks,i=a&&a[e];if(!i)return null;var c=t.range()[0],s=Math.round(r(e)+r.bandwidth()/2+5),p=o?"histogram-tick-start":"histogram-tick";return l.createElement("text",{className:"bar-chart-tick "+p,x:c,y:s,dx:o?0:"-1em",dy:"0.3em"},i)},t.prototype.renderBars=function(e,t){var r=this;return l.createElement("g",null,this.props.bars.map(function(n,o){return l.createElement("g",{key:o},r.renderBar(n,o,e,t),r.renderValue(n,o,e,t),r.renderTick(o,e,t))}))},t.prototype.render=function(){var e=this.props,t=e.bars,r=e.width,n=e.height,o=e.padding,a=void 0===o?d:o,i=r-a[1]-a[3],c=Object(u.b)().domain([0,Object(p.e)(t)]).range([0,i]),s=n-a[0]-a[2],m=Object(u.a)().domain(t.map(function(e,t){return t})).rangeRound([0,s]);return l.createElement("svg",{className:"bar-chart",width:this.props.width,height:this.props.height},l.createElement("g",{transform:"translate("+(this.props.alignTicks?4:a[3])+", "+a[0]+")"},this.renderBars(c,m)))},t}(l.PureComponent),b=r(37),y=r(1);function v(e){return e.length>10?e.substr(0,7)+"...":e}var g=r(13);t.a=Object(o.connect)(function(e){return{languages:Object(g.getLanguages)(e)}})(function(e){var t=e.distribution.split(";").map(function(e){var t=e.split("=");return{language:t[0],lines:parseInt(t[1],10)}}),r=(t=i()(t,function(e){return-e.lines})).map(function(e){return e.lines}),n=t.map(function(t){return function(t){if("<null>"===t)return Object(y.l)("unknown");var r=s()(e.languages,{key:t});return r?r.name:t}(t.language)}).map(v),o=t.map(function(e){return e.lines>1e3?Object(b.formatMeasure)(e.lines,"INT"):""}),a=t.map(function(e){return Object(b.formatMeasure)(e.lines,"SHORT_INT")});return l.createElement(h,{alignTicks:e.alignTicks,bars:r,height:25*t.length,padding:[0,60,0,80],yTicks:n,yTooltips:o,yValues:a,width:e.width})})},1051:function(e,t){e.exports=function(e,t,r){var n=-1,o=e.length;t<0&&(t=-t>o?0:o+t),(r=r>o?o:r)<0&&(r+=o),o=t>r?0:r-t>>>0,t>>>=0;for(var a=Array(o);++n<o;)a[n]=e[n+t];return a}},1052:function(e,t,r){var n=r(1051),o=r(344),a=r(904),i=Math.ceil,c=Math.max;e.exports=function(e,t,r){t=(r?o(e,t,r):void 0===t)?1:c(a(t),0);var s=null==e?0:e.length;if(!s||t<1)return[];for(var l=0,p=0,u=Array(i(s/t));l<s;)u[p++]=n(e,l,l+=t);return u}},1056:function(e,t){e.exports=function(e,t){return e<t}},1057:function(e,t,r){var n=r(978),o=r(114),a=r(1056);e.exports=function(e,t){return e&&e.length?n(e,o(t,2),a):void 0}},1061:function(e,t){e.exports=function(e,t){return e>t}},1064:function(e,t,r){(e.exports=r(28)(!1)).push([e.i,".histogram-tick{text-anchor:end}.histogram-tick-start,.histogram-value{text-anchor:start}",""])},1065:function(e,t,r){var n=r(1064);"string"==typeof n&&(n=[[e.i,n,""]]);var o={hmr:!0,transform:void 0,insertInto:void 0};r(27)(n,o);n.locals&&(e.exports=n.locals)},1066:function(e,t,r){"use strict";r.d(t,"a",function(){return a});var n=r(0),o=r(11);function a(e){var t=e.className,r=e.fill,a=void 0===r?"currentColor":r,i=e.size;return n.createElement(o.a,{className:t,size:i},n.createElement("path",{d:"M14.7 3.4v3.3c0 .1 0 .2-.1.2s-.2 0-.3-.1l-.9-.9-4.8 4.8c-.1.1-.1.1-.2.1s-.1 0-.2-.1L6.4 9l-3.2 3.2-1.5-1.5 4.5-4.5c.1-.1.1-.1.2-.1s.1 0 .2.1L8.4 8l3.5-3.5-.9-1c-.1-.1-.1-.2-.1-.3s.1-.1.2-.1h3.3c.1 0 .1 0 .2.1.1 0 .1.1.1.2z",style:{fill:a}}))}},1124:function(e,t,r){"use strict";var n=r(1057),o=r.n(n),a=r(0),i=r.n(a),c=r(4),s=r(993),l=r.n(s),p=r(1e3);function u(e){var t=e.style,r=e.translatedName,n=e.value;return i.a.createElement("tr",{className:"overview-analysis-graph-tooltip-line"},i.a.createElement("td",{className:"thin"},i.a.createElement(p.a,{className:"little-spacer-right line-chart-legend line-chart-legend-"+t})),i.a.createElement("td",{className:"overview-analysis-graph-tooltip-value text-right little-spacer-right thin"},n),i.a.createElement("td",{className:"text-ellipsis overview-analysis-graph-tooltip-description"},r))}var m,f=r(216),d=r(135),h=(m=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var r in t)t.hasOwnProperty(r)&&(e[r]=t[r])},function(e,t){function r(){this.constructor=e}m(e,t),e.prototype=null===t?Object.create(t):(r.prototype=t.prototype,new r)}),b=function(e){function t(){return null!==e&&e.apply(this,arguments)||this}return h(t,e),t.prototype.render=function(){var e=this,t=this.props.tooltipIdx,r=this.props.tooltipPos,n=d.b.RightTop;return r>this.props.graphWidth-160&&(r-=160,n=d.b.LeftTop),i.a.createElement(d.a,{className:"overview-analysis-graph-popup disabled-pointer-events",placement:n,style:{top:16,left:r,width:160}},i.a.createElement("div",{className:"overview-analysis-graph-tooltip"},i.a.createElement("div",{className:"overview-analysis-graph-tooltip-title"},i.a.createElement(f.a,{date:this.props.selectedDate,long:!0})),i.a.createElement("table",{className:"width-100"},i.a.createElement("tbody",null,this.props.series.map(function(r,n){var o=r.data[t];return!o||!o.y&&0!==o.y?null:i.a.createElement(u,{key:r.name,style:n.toString(),translatedName:r.translatedName,value:e.props.formatValue(o.y)})})))))},t}(i.a.PureComponent),y=r(1055),v=r(948),g=r(16),E=r(37),_=r(65),j=function(){var e=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var r in t)t.hasOwnProperty(r)&&(e[r]=t[r])};return function(t,r){function n(){this.constructor=t}e(t,r),t.prototype=null===r?Object.create(r):(n.prototype=r.prototype,new n)}}(),O=Object.assign||function(e){for(var t,r=1,n=arguments.length;r<n;r++)for(var o in t=arguments[r])Object.prototype.hasOwnProperty.call(t,o)&&(e[o]=t[o]);return e},x=[4,0,4,0],N=1,w=3,k=function(e){function t(t){var r=e.call(this,t)||this;r.formatValue=function(e){return Object(E.formatMeasure)(e,Object(E.getShortType)(Object(v.n)(r.state.series)))},r.getDisplayedMetrics=function(e,t){var r=Object(v.l)(e,t);return!r||r.length<=0?Object(v.l)(v.b,t):r},r.getSeries=function(e,t,n,a){var i=e;if(!i)return[];var c=r.getDisplayedMetrics(t,n),s=o()(c.map(function(e){return i[e].find(function(e){return e.value||0===e.value})}),"date"),l=c.map(function(e){return{metric:e,history:s?i[e].filter(function(e){return e.date>=s.date}):i[e]}});return Object(v.j)(l,t,a,c)},r.handleClick=function(){r.context.router.push({pathname:"/project/activity",query:O({id:r.props.project},Object(_.c)(r.props.branchLike))})},r.updateTooltip=function(e,t,n){return r.setState({selectedDate:e,tooltipXPos:t,tooltipIdx:n})};var n=Object(g.a)(v.f),a=Object(g.a)(v.e)||"issues",i=n?n.split(","):[],c=Object(v.x)(r.getSeries(t.history,a,i,t.metrics),N,w);return r.state={customMetrics:i,graph:a,selectedDate:null,series:c.length>0?c[0]:[],tooltipIdx:null,tooltipXPos:null},r}return j(t,e),t.prototype.componentWillReceiveProps=function(e){if(e.history!==this.props.history||e.metrics!==this.props.metrics){var t=Object(g.a)(v.f),r=Object(g.a)(v.e)||"issues",n=t?t.split(","):[],o=Object(v.x)(this.getSeries(e.history,r,n,e.metrics),N,w);this.setState({customMetrics:n,graph:r,series:o.length>0?o[0]:[]})}},t.prototype.renderTimeline=function(){var e=this,t=this.state,r=t.graph,n=t.selectedDate,o=t.series,a=t.tooltipIdx,c=t.tooltipXPos;return i.a.createElement(l.a,{disableHeight:!0},function(t){var s=t.width;return i.a.createElement("div",null,i.a.createElement(y.a,{endDate:null,startDate:null,height:80,width:s,hideGrid:!0,hideXAxis:!0,interpolate:"linear",metricType:Object(v.n)(o),padding:x,series:o,showAreas:["coverage","duplications"].includes(r),updateTooltip:e.updateTooltip}),null!=n&&null!=c&&null!=a&&i.a.createElement(b,{formatValue:e.formatValue,graph:r,graphWidth:s,metrics:e.props.metrics,selectedDate:n,series:o,tooltipIdx:a,tooltipPos:c}))})},t.prototype.render=function(){var e=this.state.series;return Object(v.q)(e)?i.a.createElement("div",{className:"overview-analysis-graph big-spacer-bottom spacer-top",onClick:this.handleClick,tabIndex:0,role:"link"},this.renderTimeline()):this.props.renderWhenEmpty?this.props.renderWhenEmpty():null},t.contextTypes={router:c.object},t}(i.a.PureComponent);t.a=k},1150:function(e,t,r){var n=r(978),o=r(1061),a=r(171);e.exports=function(e){return e&&e.length?n(e,a,o):void 0}},1280:function(e,t,r){(e.exports=r(28)(!1)).push([e.i,".portfolio-measure-secondary-value{line-height:24px;font-size:18px;font-weight:300}.portfolio-grid{position:relative;z-index:10;display:flex;justify-content:space-around;align-items:center}.portfolio-grid>li{vertical-align:top;width:50%;text-align:center}.portfolio-grid>li.text-middle{vertical-align:middle}.portfolio-freshness{line-height:24px;margin-top:12px;color:#777;font-size:12px;white-space:nowrap}.portfolio-effort{margin-top:12px;padding-top:12px;border-top:1px solid #e6e6e6}.portfolio-boxes{display:flex;justify-content:space-between;align-items:stretch;margin-bottom:20px;padding:15px 0;border:1px solid #e6e6e6;background-color:#fff}.portfolio-box{position:relative;width:25%;padding:0 5px;border-radius:3px;box-sizing:border-box;text-align:center}.portfolio-box-title{margin-bottom:25px;font-size:16px}.portfolio-box-title>.button-small>svg{margin-top:0}.portfolio-box-rating,.portfolio-box-rating .rating{display:block;width:120px;height:120px;line-height:120px}.portfolio-box-rating{margin:0 auto;border:none}.portfolio-box-rating .rating{border-radius:120px;font-size:60px;text-align:center}.portfolio-sub-components table.data>thead>tr>th{font-size:13px;text-transform:none}.portfolio-sub-components-cell{width:90px}.portfolio-meta-header{margin-bottom:4px;color:#444}.portfolio-meta-card{min-width:200px;box-sizing:border-box}.portfolio-meta-card+.portfolio-meta-card{margin-top:16px;padding-top:15px;border-top:1px solid #e6e6e6}",""])},1281:function(e,t,r){var n=r(1280);"string"==typeof n&&(n=[[e.i,n,""]]);var o={hmr:!0,transform:void 0,insertInto:void 0};r(27)(n,o);n.locals&&(e.exports=n.locals)},1583:function(e,t,r){"use strict";r.r(t);var n=r(0),o=r(15),a=r(2),i=r(1044),c=r(920),s=r(1),l=r(41);function p(e){var t=e.component,r=e.measures,o=r.projects,p=r.ncloc,u=r.ncloc_language_distribution;return n.createElement("section",{className:"big-spacer-bottom",id:"portfolio-summary"},t.description&&n.createElement("div",{className:"big-spacer-bottom"},t.description),n.createElement("ul",{className:"portfolio-grid"},n.createElement("li",null,n.createElement("div",{className:"portfolio-measure-secondary-value"},o?n.createElement(a.Link,{to:Object(l.f)({componentKey:t.key,metric:"projects"})},n.createElement(c.a,{metricKey:"projects",metricType:"SHORT_INT",value:o})):"0"),n.createElement("div",{className:"spacer-top text-muted"},Object(s.l)("projects"))),n.createElement("li",null,n.createElement("div",{className:"portfolio-measure-secondary-value"},p?n.createElement(a.Link,{to:Object(l.f)({componentKey:t.key,metric:"ncloc"})},n.createElement(c.a,{metricKey:"ncloc",metricType:"SHORT_INT",value:p})):"0"),n.createElement("div",{className:"spacer-top text-muted"},Object(s.l)("metric.ncloc.name")))),u&&n.createElement("div",{className:"big-spacer-top"},n.createElement(i.a,{distribution:u,width:260})))}var u=r(230),m=r(5),f=r(10);var d,h=r(34),b=(d=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var r in t)t.hasOwnProperty(r)&&(e[r]=t[r])},function(e,t){function r(){this.constructor=e}d(e,t),e.prototype=null===t?Object.create(t):(r.prototype=t.prototype,new r)}),y=function(e){function t(t){var r=e.call(this,t)||this;return r.mounted=!1,r.stopLoading=function(){r.mounted&&r.setState({loading:!1})},r.handleSubscription=function(e){r.mounted&&r.setState({loading:!1,subscribed:e})},r.handleSubscribe=function(){var e;r.setState({loading:!0}),(e=r.props.component,Object(m.post)("/api/governance_reports/subscribe",{componentKey:e}).catch(f.a)).then(function(){return r.handleSubscription(!0)}).catch(r.stopLoading)},r.handleUnsubscribe=function(){var e;r.setState({loading:!0}),(e=r.props.component,Object(m.post)("/api/governance_reports/unsubscribe",{componentKey:e}).catch(f.a)).then(function(){return r.handleSubscription(!1)}).catch(r.stopLoading)},r.getEffectiveFrequencyText=function(){var e=r.props.status.componentFrequency||r.props.status.globalFrequency;return Object(s.l)("report.frequency",e,"effective")},r.renderLoading=function(){return r.state.loading&&n.createElement("i",{className:"spacer-left spinner"})},r.renderWhenSubscribed=function(){return n.createElement("div",{className:"js-subscribed"},n.createElement("div",{className:"spacer-bottom"},n.createElement(u.a,{className:"pull-left spacer-right"}),n.createElement("div",{className:"overflow-hidden"},Object(s.m)("report.subscribed",r.getEffectiveFrequencyText()))),n.createElement(h.a,{onClick:r.handleUnsubscribe},Object(s.l)("report.unsubscribe")),r.renderLoading())},r.renderWhenNotSubscribed=function(){return n.createElement("div",{className:"js-not-subscribed"},n.createElement("p",{className:"spacer-bottom"},Object(s.m)("report.unsubscribed",r.getEffectiveFrequencyText())),n.createElement(h.a,{className:"js-report-subscribe",onClick:r.handleSubscribe},Object(s.l)("report.subscribe")),r.renderLoading())},r.state={subscribed:t.status.subscribed,loading:!1},r}return b(t,e),t.prototype.componentDidMount=function(){this.mounted=!0},t.prototype.componentWillReceiveProps=function(e){e.status.subscribed!==this.props.status.subscribed&&this.setState({subscribed:e.status.subscribed})},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){var e,t=!!this.props.currentUser.email,r=this.state.subscribed;return e=t?r?this.renderWhenSubscribed():this.renderWhenNotSubscribed():n.createElement("p",{className:"note js-no-email"},Object(s.l)("report.no_email_to_subscribe")),n.createElement("div",{className:"big-spacer-top js-report-subscription"},e)},t}(n.PureComponent),v=r(13),g=Object(o.connect)(function(e){return{currentUser:Object(v.getCurrentUser)(e)}})(y),E=function(){var e=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var r in t)t.hasOwnProperty(r)&&(e[r]=t[r])};return function(t,r){function n(){this.constructor=t}e(t,r),t.prototype=null===r?Object.create(r):(n.prototype=r.prototype,new n)}}(),_=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.mounted=!1,t.state={loading:!0},t.renderHeader=function(){return n.createElement("h4",null,Object(s.l)("report.page"))},t}return E(t,e),t.prototype.componentDidMount=function(){this.mounted=!0,this.loadStatus()},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.loadStatus=function(){var e,t=this;(e=this.props.component.key,Object(m.getJSON)("/api/governance_reports/status",{componentKey:e}).catch(f.a)).then(function(e){t.mounted&&t.setState({status:e,loading:!1})},function(){t.mounted&&t.setState({loading:!1})})},t.prototype.render=function(){var e=this.props.component,t=this.state,r=t.status;return t.loading?n.createElement("div",null,this.renderHeader(),n.createElement("i",{className:"spinner"})):r?n.createElement("div",null,this.renderHeader(),!r.canDownload&&n.createElement("div",{className:"note js-report-cant-download"},Object(s.l)("report.cant_download")),r.canDownload&&n.createElement("div",{className:"js-report-can-download"},Object(s.l)("report.can_download"),n.createElement("div",{className:"spacer-top"},n.createElement("a",{className:"button js-report-download",href:function(e){return window.baseUrl+"/api/governance_reports/download?componentKey="+encodeURIComponent(e)}(e.key),target:"_blank",download:e.name+" - Executive Report.pdf"},Object(s.l)("report.print")))),r.canSubscribe&&n.createElement(g,{component:e.key,status:r})):null},t}(n.PureComponent),j=r(1150),O=r.n(j),x=r(88),N=r(37);function w(e){var t=e.component,r=e.subComponents,o=e.total,i=r.length;if(!i)return null;var p=O()(r.map(function(e){return Number(e.measures.ncloc||0)})),u={pathname:"/code",query:{id:t}};return n.createElement("div",{className:"panel panel-white portfolio-sub-components",id:"portfolio-sub-components"},n.createElement("table",{className:"data zebra"},n.createElement("thead",null,n.createElement("tr",null,n.createElement("th",null," "),n.createElement("th",{className:"text-center portfolio-sub-components-cell"},Object(s.l)("metric_domain.Releasability")),n.createElement("th",{className:"text-center portfolio-sub-components-cell"},Object(s.l)("metric_domain.Reliability")),n.createElement("th",{className:"text-center portfolio-sub-components-cell"},Object(s.l)("metric_domain.Security")),n.createElement("th",{className:"text-center portfolio-sub-components-cell"},Object(s.l)("metric_domain.Maintainability")),n.createElement("th",{className:"text-center portfolio-sub-components-cell"},Object(s.l)("metric.ncloc.name")))),n.createElement("tbody",null,r.map(function(e){return n.createElement("tr",{key:e.key},n.createElement("td",null,n.createElement(a.Link,{to:Object(l.s)(e.refKey||e.key),className:"link-with-icon"},n.createElement(x.a,{qualifier:e.qualifier})," ",e.name)),"TRK"===e.qualifier?k(e.measures,"alert_status","LEVEL"):k(e.measures,"releasability_rating","RATING"),k(e.measures,"reliability_rating","RATING"),k(e.measures,"security_rating","RATING"),k(e.measures,"sqale_rating","RATING"),function(e,t){var r=Number(e.ncloc||0),o=t>0?Math.max(1,Math.round(r/t*50)):0;return n.createElement("td",{className:"text-right"},n.createElement("span",{className:"note"},n.createElement(c.a,{metricKey:"ncloc",metricType:"SHORT_INT",value:e.ncloc})),t>0&&n.createElement("svg",{width:"50",height:"16",className:"spacer-left"},n.createElement("rect",{className:"bar-chart-bar",x:"0",y:"3",width:o,height:"10"})))}(e.measures,p))}))),o>i&&n.createElement("footer",{className:"spacer-top note text-center"},Object(s.m)("x_of_y_shown",Object(N.formatMeasure)(i,"INT"),Object(N.formatMeasure)(o,"INT")),n.createElement(a.Link,{to:u,className:"spacer-left"},Object(s.l)("show_more"))))}function k(e,t,r){return n.createElement("td",{className:"text-center"},n.createElement(c.a,{metricKey:t,metricType:r,value:e[t]}))}var S=r(43),T=r(223),M=r(225);function C(e){var t=e.lastChange,r=e.rating;if(!t)return n.createElement("div",{className:"portfolio-freshness"},r&&n.createElement(S.b,{defaultMessage:Object(s.l)("portfolio.has_always_been_x"),id:"portfolio.has_always_been_x",values:{rating:n.createElement(M.a,{small:!0,value:r})}}));var o=JSON.parse(t);return n.createElement("div",{className:"portfolio-freshness"},n.createElement(S.b,{defaultMessage:Object(s.l)("portfolio.was_x_y"),id:"portfolio.was_x_y",values:{rating:n.createElement(M.a,{small:!0,value:o.value}),date:n.createElement(T.a,{date:o.date})}}))}var P=r(228);function R(e){var t=e.component,r=e.measures,o=r.releasability_rating,i=r.last_change_on_releasability_rating,p=r.releasability_effort;return n.createElement("div",{className:"portfolio-box portfolio-releasability"},n.createElement("h2",{className:"portfolio-box-title"},Object(s.l)("metric_domain.Releasability")),o&&n.createElement(a.Link,{to:Object(l.f)({componentKey:t,metric:"alert_status"}),className:"portfolio-box-rating"},n.createElement(M.a,{value:o})),n.createElement(C,{lastChange:i,rating:o}),p&&Number(p)>0&&n.createElement("div",{className:"portfolio-effort"},n.createElement(a.Link,{to:Object(l.f)({componentKey:t,metric:"alert_status"})},n.createElement("span",null,n.createElement(c.a,{className:"little-spacer-right",metricKey:"projects",metricType:"SHORT_INT",value:p}),1===Number(p)?"project":"projects"))," ",n.createElement(P.a,{level:"ERROR",small:!0})))}function I(e){var t=e.component,r=e.effort,o=e.metricKey;return n.createElement("div",{className:"portfolio-effort"},n.createElement(S.b,{defaultMessage:Object(s.l)("portfolio.x_in_y"),id:"portfolio.x_in_y",values:{projects:n.createElement(a.Link,{to:Object(l.f)({componentKey:t,metric:o})},n.createElement("span",null,n.createElement(c.a,{className:"little-spacer-right",metricKey:"projects",metricType:"SHORT_INT",value:String(r.projects)}),Object(s.l)("projects_"))),rating:n.createElement(M.a,{small:!0,value:r.rating})}}))}var K=r(991);function L(e){var t=e.component,r=e.metric;return n.createElement(a.Link,{className:"button button-small spacer-left text-text-bottom",to:Object(l.f)({componentKey:t,metric:r})},n.createElement(K.a,{size:14}))}var q=r(1066);function D(e){var t=e.component,r=e.metric;return n.createElement(a.Link,{className:"button button-small spacer-left text-text-bottom",to:Object(l.p)(t,r)},n.createElement(q.a,{size:14}))}function z(e){var t=e.component,r=e.metric,o=e.value;return n.createElement(a.Link,{to:Object(l.q)(t,r),className:"portfolio-box-rating"},n.createElement(M.a,{value:o}))}function W(e){var t=e.component,r=e.measures,o=r.reliability_rating,a=r.last_change_on_reliability_rating,i=r.reliability_rating_effort,c=i?JSON.parse(i):void 0;return n.createElement("div",{className:"portfolio-box portfolio-reliability"},n.createElement("h2",{className:"portfolio-box-title"},Object(s.l)("metric_domain.Reliability"),n.createElement(L,{component:t,metric:"Reliability"}),n.createElement(D,{component:t,metric:"reliability_rating"})),o&&n.createElement(z,{component:t,metric:"reliability_rating",value:o}),n.createElement(C,{lastChange:a,rating:o}),c&&n.createElement(I,{component:t,effort:c,metricKey:"reliability_rating"}))}function A(e){var t=e.component,r=e.measures,o=r.security_rating,a=r.last_change_on_security_rating,i=r.security_rating_effort,c=i?JSON.parse(i):void 0;return n.createElement("div",{className:"portfolio-box portfolio-security"},n.createElement("h2",{className:"portfolio-box-title"},Object(s.l)("metric_domain.Security"),n.createElement(L,{component:t,metric:"Security"}),n.createElement(D,{component:t,metric:"security_rating"})),o&&n.createElement(z,{component:t,metric:"security_rating",value:o}),n.createElement(C,{lastChange:a,rating:o}),c&&n.createElement(I,{component:t,effort:c,metricKey:"security_rating"}))}function H(e){var t=e.component,r=e.measures,o=r.sqale_rating,a=r.last_change_on_maintainability_rating,i=r.maintainability_rating_effort,c=i?JSON.parse(i):void 0;return n.createElement("div",{className:"portfolio-box portfolio-maintainability"},n.createElement("h2",{className:"portfolio-box-title"},Object(s.l)("metric_domain.Maintainability"),n.createElement(L,{component:t,metric:"Maintainability"}),n.createElement(D,{component:t,metric:"sqale_rating"})),o&&n.createElement(z,{component:t,metric:"sqale_rating",value:o}),n.createElement(C,{lastChange:a,rating:o}),c&&n.createElement(I,{component:t,effort:c,metricKey:"sqale_rating"}))}var U=r(948),V=r(1124),J=r(1050),G=r(25),F=r(16),B=function(){var e=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var r in t)t.hasOwnProperty(r)&&(e[r]=t[r])};return function(t,r){function n(){this.constructor=t}e(t,r),t.prototype=null===r?Object.create(r):(n.prototype=r.prototype,new n)}}(),X=V.a,Q=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.mounted=!1,t.state={loading:!0},t.fetchHistory=function(){var e=t.props.component,r=Object(F.a)(U.f),n=Object(U.l)(Object(F.a)(U.e)||"issues",r?r.split(","):[]);return(!n||n.length<=0)&&(n=Object(U.l)(U.b,[])),t.setState({loading:!0}),Object(J.a)({component:e,metrics:n.join()}).then(function(e){if(t.mounted){var r={};e.measures.forEach(function(e){var t=e.history.map(function(e){return{date:Object(G.e)(e.date),value:e.value}});r[e.metric]=t}),t.setState({history:r,loading:!1})}},function(){t.mounted&&t.setState({loading:!1})})},t.renderWhenEmpty=function(){return n.createElement("div",{className:"note"},Object(s.l)("component_measures.no_history"))},t}return B(t,e),t.prototype.componentDidMount=function(){this.mounted=!0,this.fetchHistory()},t.prototype.componentDidUpdate=function(e){e.component!==this.props.component&&this.fetchHistory()},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){return n.createElement("div",{className:"big-spacer-bottom"},n.createElement("h4",null,Object(s.l)("project_activity.page")),this.state.loading?n.createElement("i",{className:"spinner"}):void 0!==this.state.history&&n.createElement(X,{history:this.state.history,metrics:this.props.metrics,project:this.props.component,renderWhenEmpty:this.renderWhenEmpty}))},t}(n.PureComponent);var Y=["projects","ncloc","ncloc_language_distribution","releasability_rating","releasability_effort","sqale_rating","maintainability_rating_effort","reliability_rating","reliability_rating_effort","security_rating","security_rating_effort","last_change_on_releasability_rating","last_change_on_maintainability_rating","last_change_on_security_rating","last_change_on_reliability_rating"],Z=["ncloc","releasability_rating","security_rating","reliability_rating","sqale_rating","alert_status"];function $(e){var t={};return e.forEach(function(e){t[e.metric]=e.value}),t}var ee=r(234),te=r(52),re=r(116);r(1281);r.d(t,"App",function(){return ae});var ne=function(){var e=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var r in t)t.hasOwnProperty(r)&&(e[r]=t[r])};return function(t,r){function n(){this.constructor=t}e(t,r),t.prototype=null===r?Object.create(r):(n.prototype=r.prototype,new n)}}(),oe=Object.assign||function(e){for(var t,r=1,n=arguments.length;r<n;r++)for(var o in t=arguments[r])Object.prototype.hasOwnProperty.call(t,o)&&(e[o]=t[o]);return e},ae=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.mounted=!1,t.state={loading:!0},t.isEmpty=function(){return void 0===t.state.measures||void 0===t.state.measures.ncloc},t.isNotComputed=function(){return t.state.measures&&void 0===t.state.measures.reliability_rating},t}return ne(t,e),t.prototype.componentDidMount=function(){this.mounted=!0,this.props.fetchMetrics(),this.fetchData()},t.prototype.componentDidUpdate=function(e){e.component!==this.props.component&&this.fetchData()},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.fetchData=function(){var e=this;this.setState({loading:!0}),Promise.all([Object(ee.d)({componentKey:this.props.component.key,metricKeys:Y.join()}),Object(te.h)(this.props.component.key,Z,{ps:20,s:"qualifier"})]).then(function(t){var r=t[0],n=t[1];e.mounted&&e.setState({loading:!1,measures:$(r),subComponents:n.components.map(function(e){return oe({},e,{measures:$(e.measures)})}),totalSubComponents:n.paging.total})},function(){e.mounted&&e.setState({loading:!1})})},t.prototype.renderSpinner=function(){return n.createElement("div",{className:"page page-limited"},n.createElement("div",{className:"text-center"},n.createElement("i",{className:"spinner spinner-margin"})))},t.prototype.renderEmpty=function(){return n.createElement("div",{className:"empty-search"},n.createElement("h3",null,this.state.measures&&this.state.measures.projects?Object(s.l)("portfolio.no_lines_of_code"):Object(s.l)("portfolio.empty")))},t.prototype.renderWhenNotComputed=function(){return n.createElement("div",{className:"empty-search"},n.createElement("h3",null,Object(s.l)("portfolio.not_computed")))},t.prototype.renderMain=function(){var e=this.props.component,t=this.state,r=t.measures,o=t.subComponents,a=t.totalSubComponents;return this.isEmpty()?this.renderEmpty():this.isNotComputed()?this.renderWhenNotComputed():n.createElement("div",null,n.createElement("div",{className:"portfolio-boxes"},n.createElement(R,{component:e.key,measures:r}),n.createElement(W,{component:e.key,measures:r}),n.createElement(A,{component:e.key,measures:r}),n.createElement(H,{component:e.key,measures:r})),void 0!==o&&void 0!==a&&n.createElement(w,{component:e.key,subComponents:o,total:a}))},t.prototype.render=function(){var e=this.props.component,t=this.state,r=t.loading,o=t.measures;return r?this.renderSpinner():n.createElement("div",{className:"page page-limited"},n.createElement("div",{className:"page-with-sidebar"},n.createElement("div",{className:"page-main"},this.renderMain()),n.createElement("aside",{className:"page-sidebar-fixed"},n.createElement("div",{className:"portfolio-meta-card"},n.createElement("h4",{className:"portfolio-meta-header"},Object(s.l)("overview.about_this_portfolio")),n.createElement(p,{component:e,measures:o||{}})),n.createElement("div",{className:"portfolio-meta-card"},n.createElement(Q,{component:e.key,metrics:this.props.metrics})),n.createElement("div",{className:"portfolio-meta-card"},n.createElement(_,{component:e})))))},t}(n.PureComponent),ie={fetchMetrics:re.e};t.default=Object(o.connect)(function(e){return{metrics:Object(v.getMetrics)(e)}},ie)(ae)},901:function(e,t,r){var n=r(162),o=r(340),a=Object.prototype.hasOwnProperty,i=o(function(e,t,r){a.call(e,r)?e[r].push(t):n(e,r,[t])});e.exports=i},904:function(e,t,r){var n=r(341);e.exports=function(e){var t=n(e),r=t%1;return t==t?r?t-r:t:0}},911:function(e,t){e.exports=function(e,t,r,n){for(var o=e.length,a=r+(n?1:-1);n?a--:++a<o;)if(t(e[a],a,e))return a;return-1}},920:function(e,t,r){"use strict";r.d(t,"a",function(){return l});var n=r(0),o=r(972),a=r(225),i=r(228),c=r(36),s=r(37);function l(e){var t=e.className,r=e.decimals,l=e.metricKey,p=e.metricType,u=e.small,m=e.value;if(void 0===m)return n.createElement("span",null,"–");if("LEVEL"===p)return n.createElement(i.a,{className:t,level:m,small:u});if("RATING"!==p){var f=Object(s.formatMeasure)(m,p,{decimals:r});return n.createElement("span",{className:t},null!=f?f:"–")}var d=Object(o.b)(l,Number(m)),h=n.createElement(a.a,{small:u,value:m});return d?n.createElement(c.a,{overlay:d},n.createElement("span",{className:t},h)):h}},925:function(e,t,r){var n=r(114),o=r(163),a=r(164);e.exports=function(e){return function(t,r,i){var c=Object(t);if(!o(t)){var s=n(r,3);t=a(t),r=function(e){return s(c[e],e,c)}}var l=e(t,r,i);return l>-1?c[s?t[l]:l]:void 0}}},950:function(e,t,r){var n=r(911),o=r(114),a=r(904),i=Math.max;e.exports=function(e,t,r){var c=null==e?0:e.length;if(!c)return-1;var s=null==r?0:a(r);return s<0&&(s=i(c+s,0)),n(e,o(t,3),s)}},951:function(e,t,r){var n=r(925)(r(950));e.exports=n},972:function(e,t,r){"use strict";r.d(t,"a",function(){return i}),r.d(t,"b",function(){return c});var n=r(37),o=Object.assign||function(e){for(var t,r=1,n=arguments.length;r<n;r++)for(var o in t=arguments[r])Object.prototype.hasOwnProperty.call(t,o)&&(e[o]=t[o]);return e},a=["sqale_rating","reliability_rating","security_rating"];function i(e,t){return o({},e,{metric:t[e.metric],leak:function(e){if(!e||!e.periods)return;var t=e.periods.find(function(e){return 1===e.index});return t&&t.value}(e)})}function c(e,t){var r=Object(n.isDiffMetric)(e)?e.substr(4):e;if(a.includes(r))return Object(n.getRatingTooltip)(r,t)}},978:function(e,t,r){var n=r(140);e.exports=function(e,t,r){for(var o=-1,a=e.length;++o<a;){var i=e[o],c=t(i);if(null!=c&&(void 0===s?c==c&&!n(c):r(c,s)))var s=c,l=i}return l}},991:function(e,t,r){"use strict";r.d(t,"a",function(){return a});var n=r(0),o=r(11);function a(e){var t=e.className,r=e.fill,a=void 0===r?"currentColor":r,i=e.size;return n.createElement(o.a,{className:t,size:i,style:{fillRule:"nonzero"}},n.createElement("path",{d:"M4.1 10.2c1 0 1.9.8 1.9 1.9S5.1 14 4.1 14s-1.9-.8-1.9-1.9.8-1.9 1.9-1.9m0-2C2 8.2.2 9.9.2 12.1S1.9 16 4.1 16 8 14.3 8 12.1 6.2 8.2 4.1 8.2zM10.3 2c2 0 3.7 1.7 3.7 3.7s-1.7 3.7-3.7 3.7-3.8-1.6-3.8-3.7S8.2 2 10.3 2m0-2C7.1 0 4.5 2.6 4.5 5.7s2.6 5.7 5.7 5.7S16 8.9 16 5.7 13.4 0 10.3 0z",style:{fill:a}}))}}}]);
//# sourceMappingURL=293.65b88b61.chunk.js.map