(window.webpackJsonp=window.webpackJsonp||[]).push([[280],{1567:function(e,t,n){"use strict";n.r(t);var r,o=n(0),a=n(212),s=n.n(a),c=n(243),i=n(42),l=n(213),u=n(897),m=n(34),p=n(1),d=(r=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])},function(e,t){function n(){this.constructor=e}r(e,t),e.prototype=null===t?Object.create(t):(n.prototype=t.prototype,new n)}),h=function(e){function t(t){var n=e.call(this,t)||this;return n.mounted=!1,n.handleSubmit=function(){return n.state.metricKey?n.props.onSubmit({description:n.state.description,metricKey:n.state.metricKey,value:n.state.value}).then(n.props.onClose):Promise.reject(void 0)},n.fetchCustomMetrics=function(){n.setState({loading:!0}),Object(c.c)({isCustom:!0}).then(function(e){n.mounted&&n.setState({loading:!1,metrics:e})},function(){n.mounted&&n.setState({loading:!1})})},n.handleMetricSelect=function(e){var t=e.value;n.setState({metricKey:t})},n.handleDescriptionChange=function(e){n.setState({description:e.currentTarget.value})},n.handleValueChange=function(e){n.setState({value:e.currentTarget.value})},n.renderMetricSelect=function(e){return e.length||n.state.loading?o.createElement("div",{className:"modal-field"},o.createElement("label",{htmlFor:"create-custom-measure-metric"},Object(p.l)("custom_measures.metric"),o.createElement("em",{className:"mandatory"},"*")),n.state.loading?o.createElement("i",{className:"spinner"}):o.createElement(l.c,{autoFocus:!0,clearable:!1,onChange:n.handleMetricSelect,options:e,value:n.state.metricKey})):o.createElement("div",{className:"alert alert-warning"},Object(p.l)("custom_measures.all_metrics_taken"))},n.state={description:t.measure&&t.measure.description||"",loading:!1,metricKey:t.measure&&t.measure.metric.key,value:t.measure&&t.measure.value||""},n}return d(t,e),t.prototype.componentDidMount=function(){this.mounted=!0,this.props.measure||this.fetchCustomMetrics()},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){var e=this,t=this.props.skipMetrics,n=void 0===t?[]:t,r=this.state.metrics,a=(void 0===r?[]:r).filter(function(e){return!n.includes(e.key)}).map(function(e){return{label:e.name,value:e.key}}),s=!this.props.measure&&!a.length;return o.createElement(u.a,{header:this.props.header,onClose:this.props.onClose,onSubmit:this.handleSubmit},function(t){var n=t.onCloseClick,r=t.onFormSubmit,c=t.submitting;return o.createElement("form",{onSubmit:r},o.createElement("header",{className:"modal-head"},o.createElement("h2",null,e.props.header)),o.createElement("div",{className:"modal-body"},!e.props.measure&&e.renderMetricSelect(a),o.createElement("div",{className:"modal-field"},o.createElement("label",{htmlFor:"create-custom-measure-value"},Object(p.l)("value"),o.createElement("em",{className:"mandatory"},"*")),o.createElement("input",{autoFocus:void 0!==e.props.measure,id:"create-custom-measure-value",maxLength:200,name:"value",onChange:e.handleValueChange,required:!0,type:"text",value:e.state.value})),o.createElement("div",{className:"modal-field"},o.createElement("label",{htmlFor:"create-custom-measure-description"},Object(p.l)("description")),o.createElement("textarea",{id:"create-custom-measure-description",name:"description",onChange:e.handleDescriptionChange,value:e.state.description}))),o.createElement("footer",{className:"modal-foot"},o.createElement(i.a,{className:"spacer-right",loading:c}),o.createElement(m.f,{disabled:s||c,id:"create-custom-measure-submit"},e.props.confirmButtonText),o.createElement(m.e,{disabled:c,id:"create-custom-measure-cancel",onClick:n},Object(p.l)("cancel"))))})},t}(o.PureComponent),f=function(){var e=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])};return function(t,n){function r(){this.constructor=t}e(t,n),t.prototype=null===n?Object.create(n):(r.prototype=n.prototype,new r)}}(),g=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.mounted=!1,t.state={modal:!1},t.handleClick=function(){t.setState({modal:!0})},t.handleClose=function(){t.mounted&&t.setState({modal:!1})},t}return f(t,e),t.prototype.componentDidMount=function(){this.mounted=!0},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){return o.createElement(o.Fragment,null,o.createElement(m.a,{id:"custom-measures-create",onClick:this.handleClick},Object(p.l)("create")),this.state.modal&&o.createElement(h,{confirmButtonText:Object(p.l)("create"),header:Object(p.l)("custom_measures.create_custom_measure"),onClose:this.handleClose,onSubmit:this.props.onCreate,skipMetrics:this.props.skipMetrics}))},t}(o.PureComponent);function b(e){var t=e.loading,n=e.onCreate,r=e.skipMetrics;return o.createElement("header",{className:"page-header",id:"custom-measures-header"},o.createElement("h1",{className:"page-title"},Object(p.l)("custom_measures.page")),o.createElement(i.a,{loading:t}),o.createElement("div",{className:"page-actions"},o.createElement(g,{onCreate:n,skipMetrics:r})),o.createElement("p",{className:"page-description"},Object(p.l)("custom_measures.page.description")))}var C=n(32),E=n.n(C);function v(e){var t=e.measure,n=e.onClose,r=e.onSubmit,a=Object(p.l)("custom_measures.delete_custom_measure");return o.createElement(u.a,{header:a,onClose:n,onSubmit:r},function(e){var n=e.onCloseClick,r=e.onFormSubmit,s=e.submitting;return o.createElement("form",{onSubmit:r},o.createElement("header",{className:"modal-head"},o.createElement("h2",null,a)),o.createElement("div",{className:"modal-body"},Object(p.m)("custom_measures.delete_custom_measure.confirmation",t.metric.name)),o.createElement("footer",{className:"modal-foot"},o.createElement(i.a,{className:"spacer-right",loading:s}),o.createElement(m.f,{className:"button-red",disabled:s},Object(p.l)("delete")),o.createElement(m.e,{disabled:s,onClick:n},Object(p.l)("cancel"))))})}var y=n(216);function _(e){var t=e.measure;return t.updatedAt?o.createElement(o.Fragment,null,Object(p.l)("updated_on")," ",o.createElement("span",{className:"js-custom-measure-created-at"},o.createElement(y.a,{date:t.updatedAt}))):t.createdAt?o.createElement(o.Fragment,null,Object(p.l)("created_on")," ",o.createElement("span",{className:"js-custom-measure-created-at"},o.createElement(y.a,{date:t.createdAt}))):o.createElement(o.Fragment,null,Object(p.l)("created"))}var O=n(902),j=n(36),S=n(37),N=function(){var e=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])};return function(t,n){function r(){this.constructor=t}e(t,n),t.prototype=null===n?Object.create(n):(r.prototype=n.prototype,new r)}}(),k=Object.assign||function(e){for(var t,n=1,r=arguments.length;n<r;n++)for(var o in t=arguments[n])Object.prototype.hasOwnProperty.call(t,o)&&(e[o]=t[o]);return e},w=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.mounted=!1,t.state={deleteForm:!1,editForm:!1},t.handleEditClick=function(){t.setState({editForm:!0})},t.handleDeleteClick=function(){t.setState({deleteForm:!0})},t.closeEditForm=function(){t.mounted&&t.setState({editForm:!1})},t.closeDeleteForm=function(){t.mounted&&t.setState({deleteForm:!1})},t.handleEditFormSubmit=function(e){return t.props.onEdit(k({id:t.props.measure.id},e))},t.handleDeleteFormSubmit=function(){return t.props.onDelete(t.props.measure.id)},t}return N(t,e),t.prototype.componentDidMount=function(){this.mounted=!0},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){var e=this.props.measure;return o.createElement("tr",{"data-metric":e.metric.key},o.createElement("td",{className:"nowrap"},o.createElement("div",null,o.createElement("span",{className:"js-custom-measure-metric-name"},e.metric.name),e.pending&&o.createElement(j.a,{overlay:Object(p.l)("custom_measures.pending_tooltip")},o.createElement("span",{className:"js-custom-measure-pending badge badge-warning spacer-left"},Object(p.l)("custom_measures.pending")))),o.createElement("span",{className:"js-custom-measure-domain note"},e.metric.domain)),o.createElement("td",{className:"nowrap"},o.createElement("strong",{className:"js-custom-measure-value"},Object(S.formatMeasure)(e.value,e.metric.type))),o.createElement("td",null,o.createElement("span",{className:"js-custom-measure-description"},e.description)),o.createElement("td",null,o.createElement(_,{measure:e})," ",Object(p.l)("by_")," ",o.createElement("span",{className:"js-custom-measure-user"},e.user.name)),o.createElement("td",{className:"thin nowrap"},o.createElement(O.c,null,o.createElement(O.b,{className:"js-custom-measure-update",onClick:this.handleEditClick},Object(p.l)("update_verb")),o.createElement(O.a,null),o.createElement(O.b,{className:"js-custom-measure-delete",destructive:!0,onClick:this.handleDeleteClick},Object(p.l)("delete")))),this.state.editForm&&o.createElement(h,{confirmButtonText:Object(p.l)("update_verb"),header:Object(p.l)("custom_measures.update_custom_measure"),measure:this.props.measure,onClose:this.closeEditForm,onSubmit:this.handleEditFormSubmit}),this.state.deleteForm&&o.createElement(v,{measure:this.props.measure,onClose:this.closeDeleteForm,onSubmit:this.handleDeleteFormSubmit}))},t}(o.PureComponent);function F(e){var t=e.measures,n=e.onDelete,r=e.onEdit;return o.createElement("div",{className:"boxed-group boxed-group-inner",id:"custom-measures-list"},t.length>0?o.createElement("table",{className:"data zebra zebra-hover"},o.createElement("thead",null,o.createElement("tr",null,o.createElement("th",null,Object(p.l)("custom_measures.metric")),o.createElement("th",null,Object(p.l)("value")),o.createElement("th",null,Object(p.l)("description")),o.createElement("th",null,Object(p.l)("date")),o.createElement("th",null))),o.createElement("tbody",null,E()(t,function(e){return e.metric.name.toLowerCase()}).map(function(e){return o.createElement(w,{key:e.id,measure:e,onDelete:n,onEdit:r})}))):o.createElement("p",null,Object(p.l)("no_results")))}var M=n(234),D=n(896),P=n(226),L=function(){var e=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])};return function(t,n){function r(){this.constructor=t}e(t,n),t.prototype=null===n?Object.create(n):(r.prototype=n.prototype,new r)}}(),x=Object.assign||function(e){for(var t,n=1,r=arguments.length;n<r;n++)for(var o in t=arguments[n])Object.prototype.hasOwnProperty.call(t,o)&&(e[o]=t[o]);return e},A=50,K=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.mounted=!1,t.state={loading:!0},t.fetchMeasures=function(){t.setState({loading:!0}),Object(M.c)({projectKey:t.props.component.key,ps:A}).then(function(e){var n=e.customMeasures,r=e.paging;t.mounted&&t.setState({loading:!1,measures:n,paging:r})},t.stopLoading)},t.fetchMore=function(){var e=t.state.paging;e&&(t.setState({loading:!0}),Object(M.c)({projectKey:t.props.component.key,p:e.pageIndex+1,ps:A}).then(function(e){var n=e.customMeasures,r=e.paging;t.mounted&&t.setState(function(e){var t=e.measures;return{loading:!1,measures:(void 0===t?[]:t).concat(n),paging:r}})},t.stopLoading))},t.stopLoading=function(){t.mounted&&t.setState({loading:!1})},t.handleCreate=function(e){return Object(M.a)(x({},e,{projectKey:t.props.component.key})).then(function(e){t.mounted&&t.setState(function(t){var n=t.measures,r=void 0===n?[]:n,o=t.paging;return{measures:r.concat([e]),paging:o&&x({},o,{total:o.total+1})}})})},t.handleEdit=function(e){return Object(M.g)(e).then(function(){t.mounted&&t.setState(function(t){var n=t.measures;return{measures:(void 0===n?[]:n).map(function(t){return t.id===e.id?x({},t,e):t})}})})},t.handleDelete=function(e){return Object(M.b)({id:e}).then(function(){t.mounted&&t.setState(function(t){var n=t.measures,r=void 0===n?[]:n,o=t.paging;return{measures:r.filter(function(t){return t.id!==e}),paging:o&&x({},o,{total:o.total-1})}})})},t}return L(t,e),t.prototype.componentDidMount=function(){this.mounted=!0,this.fetchMeasures()},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){var e=this.state,t=e.loading,n=e.measures,r=e.paging;return o.createElement(o.Fragment,null,o.createElement(D.a,{suggestions:"custom_measures"}),o.createElement(s.a,{title:Object(p.l)("custom_measures.page")}),o.createElement("div",{className:"page page-limited"},o.createElement(b,{loading:t,onCreate:this.handleCreate,skipMetrics:n&&n.map(function(e){return e.metric.key})}),n&&o.createElement(F,{measures:n,onDelete:this.handleDelete,onEdit:this.handleEdit}),n&&r&&o.createElement(P.a,{count:n.length,loadMore:this.fetchMore,ready:!t,total:r.total})))},t}(o.PureComponent);t.default=K},896:function(e,t,n){"use strict";var r,o=n(0),a=n(4),s=(r=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])},function(e,t){function n(){this.constructor=e}r(e,t),e.prototype=null===t?Object.create(t):(n.prototype=t.prototype,new n)}),c=function(e){function t(){return null!==e&&e.apply(this,arguments)||this}return s(t,e),t.prototype.componentDidMount=function(){this.context.suggestions.addSuggestions(this.props.suggestions)},t.prototype.componentDidUpdate=function(e){e.suggestions!==this.props.suggestions&&(this.context.suggestions.removeSuggestions(this.props.suggestions),this.context.suggestions.addSuggestions(e.suggestions))},t.prototype.componentWillUnmount=function(){this.context.suggestions.removeSuggestions(this.props.suggestions)},t.prototype.render=function(){return null},t.contextTypes={suggestions:a.object.isRequired},t}(o.PureComponent);t.a=c},897:function(e,t,n){"use strict";var r,o=n(0),a=n(87),s=(r=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])},function(e,t){function n(){this.constructor=e}r(e,t),e.prototype=null===t?Object.create(t):(n.prototype=t.prototype,new n)}),c=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.mounted=!1,t.state={submitting:!1},t.stopSubmitting=function(){t.mounted&&t.setState({submitting:!1})},t.handleCloseClick=function(e){e&&(e.preventDefault(),e.currentTarget.blur()),t.props.onClose()},t.handleFormSubmit=function(e){e.preventDefault(),t.submit()},t.handleSubmitClick=function(e){e&&(e.preventDefault(),e.currentTarget.blur()),t.submit()},t.submit=function(){var e=t.props.onSubmit();e&&(t.setState({submitting:!0}),e.then(t.stopSubmitting,t.stopSubmitting))},t}return s(t,e),t.prototype.componentDidMount=function(){this.mounted=!0},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){return o.createElement(a.a,{contentLabel:this.props.header,onRequestClose:this.props.onClose},this.props.children({onCloseClick:this.handleCloseClick,onFormSubmit:this.handleFormSubmit,onSubmitClick:this.handleSubmitClick,submitting:this.state.submitting}))},t}(o.Component);t.a=c},902:function(e,t,n){"use strict";var r=n(0),o=n(7),a=n(2),s=n(51),c=n(133),i=n(11);function l(e){var t=e.className,n=e.fill,o=void 0===n?"currentColor":n,a=e.size,s=void 0===a?14:a;return r.createElement(i.a,{className:t,size:s,viewBox:"0 0 14 14"},r.createElement("g",{transform:"matrix(0.0364583,0,0,0.0364583,0,-1.16667)"},r.createElement("path",{d:"M256,224C256,206.333 249.75,191.25 237.25,178.75C224.75,166.25 209.667,160 192,160C174.333,160 159.25,166.25 146.75,178.75C134.25,191.25 128,206.333 128,224C128,241.667 134.25,256.75 146.75,269.25C159.25,281.75 174.333,288 192,288C209.667,288 224.75,281.75 237.25,269.25C249.75,256.75 256,241.667 256,224ZM384,196.75L384,252.25C384,254.25 383.333,256.167 382,258C380.667,259.833 379,260.917 377,261.25L330.75,268.25C327.583,277.25 324.333,284.833 321,291C326.833,299.333 335.75,310.833 347.75,325.5C349.417,327.5 350.25,329.583 350.25,331.75C350.25,333.917 349.5,335.833 348,337.5C343.5,343.667 335.25,352.667 323.25,364.5C311.25,376.333 303.417,382.25 299.75,382.25C297.75,382.25 295.583,381.5 293.25,380L258.75,353C251.417,356.833 243.833,360 236,362.5C233.333,385.167 230.917,400.667 228.75,409C227.583,413.667 224.583,416 219.75,416L164.25,416C161.917,416 159.875,415.292 158.125,413.875C156.375,412.458 155.417,410.667 155.25,408.5L148.25,362.5C140.083,359.833 132.583,356.75 125.75,353.25L90.5,380C88.833,381.5 86.75,382.25 84.25,382.25C81.917,382.25 79.833,381.333 78,379.5C57,360.5 43.25,346.5 36.75,337.5C35.583,335.833 35,333.917 35,331.75C35,329.75 35.667,327.833 37,326C39.5,322.5 43.75,316.958 49.75,309.375C55.75,301.792 60.25,295.917 63.25,291.75C58.75,283.417 55.333,275.167 53,267L7.25,260.25C5.083,259.917 3.333,258.875 2,257.125C0.667,255.375 0,253.417 0,251.25L0,195.75C0,193.75 0.667,191.833 2,190C3.333,188.167 4.917,187.083 6.75,186.75L53.25,179.75C55.583,172.083 58.833,164.417 63,156.75C56.333,147.25 47.417,135.75 36.25,122.25C34.583,120.25 33.75,118.25 33.75,116.25C33.75,114.583 34.5,112.667 36,110.5C40.333,104.5 48.542,95.542 60.625,83.625C72.708,71.708 80.583,65.75 84.25,65.75C86.417,65.75 88.583,66.583 90.75,68.25L125.25,95C132.583,91.167 140.167,88 148,85.5C150.667,62.833 153.083,47.333 155.25,39C156.417,34.333 159.417,32 164.25,32L219.75,32C222.083,32 224.125,32.708 225.875,34.125C227.625,35.542 228.583,37.333 228.75,39.5L235.75,85.5C243.917,88.167 251.417,91.25 258.25,94.75L293.75,68C295.25,66.5 297.25,65.75 299.75,65.75C301.917,65.75 304,66.583 306,68.25C327.5,88.083 341.25,102.25 347.25,110.75C348.417,112.083 349,113.917 349,116.25C349,118.25 348.333,120.167 347,122C344.5,125.5 340.25,131.042 334.25,138.625C328.25,146.208 323.75,152.083 320.75,156.25C325.083,164.583 328.5,172.75 331,180.75L376.75,187.75C378.917,188.083 380.667,189.125 382,190.875C383.333,192.625 384,194.583 384,196.75Z",style:{fill:o}})))}var u=n(34);n.d(t,"c",function(){return d}),n.d(t,"b",function(){return h}),n.d(t,"a",function(){return f});var m,p=(m=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])},function(e,t){function n(){this.constructor=e}m(e,t),e.prototype=null===t?Object.create(t):(n.prototype=t.prototype,new n)});function d(e){return r.createElement(s.b,{className:e.className,onOpen:e.onOpen,overlay:r.createElement("ul",{className:"menu"},e.children)},r.createElement(u.a,{className:o("dropdown-toggle",e.toggleClassName,{"button-small":e.small})},r.createElement(l,{size:e.small?12:14}),r.createElement(c.a,{className:"little-spacer-left"})))}var h=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.handleClick=function(e){e.preventDefault(),e.currentTarget.blur(),t.props.onClick&&t.props.onClick()},t}return p(t,e),t.prototype.render=function(){var e=o(this.props.className,{"text-danger":this.props.destructive});return this.props.download&&"string"==typeof this.props.to?r.createElement("li",null,r.createElement("a",{className:e,download:this.props.download,href:this.props.to,id:this.props.id},this.props.children)):this.props.to?r.createElement("li",null,r.createElement(a.Link,{className:e,id:this.props.id,to:this.props.to},this.props.children)):r.createElement("li",null,r.createElement("a",{className:e,href:"#",id:this.props.id,onClick:this.handleClick},this.props.children))},t}(r.PureComponent);function f(){return r.createElement("li",{className:"divider"})}}}]);
//# sourceMappingURL=280.47c9d2ee.chunk.js.map