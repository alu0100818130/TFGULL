(window.webpackJsonp=window.webpackJsonp||[]).push([[297],{1557:function(t,e,n){"use strict";n.r(e);var o=n(0),r=n(212),i=n.n(r),a=n(898),u=n(1);function c(){return o.createElement("header",{className:"page-header"},o.createElement("div",{className:"page-title display-flex-center"},o.createElement("h1",null,Object(u.l)("project_quality_profiles.page")),o.createElement(a.a,{className:"spacer-left",doc:"quality-profiles/quality-profile-projects"})),o.createElement("div",{className:"page-description"},Object(u.l)("project_quality_profiles.page.description")))}var s,l=n(954),p=n.n(l),f=n(901),d=n.n(f),m=n(213),h=(s=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var n in e)e.hasOwnProperty(n)&&(t[n]=e[n])},function(t,e){function n(){this.constructor=t}s(t,e),t.prototype=null===e?Object.create(e):(n.prototype=e.prototype,new n)}),y=function(t){function e(){var e=null!==t&&t.apply(this,arguments)||this;return e.mounted=!1,e.state={loading:!1},e.stopLoading=function(){e.mounted&&e.setState({loading:!1})},e.handleChange=function(t){e.props.profile.key!==t.value&&(e.setState({loading:!0}),e.props.onChangeProfile(e.props.profile.key,t.value).then(e.stopLoading,e.stopLoading))},e.renderProfileName=function(t){return t.isDefault?o.createElement("span",null,o.createElement("strong",null,Object(u.l)("default")),": ",t.label):o.createElement("span",null,t.label)},e}return h(e,t),e.prototype.componentDidMount=function(){this.mounted=!0},e.prototype.componentWillUnmount=function(){this.mounted=!1},e.prototype.renderProfileSelect=function(){var t=this.props,e=t.profile,n=t.possibleProfiles.map(function(t){return{value:t.key,label:t.name,isDefault:t.isDefault}});return o.createElement(m.c,{clearable:!1,disabled:this.state.loading,onChange:this.handleChange,optionRenderer:this.renderProfileName,options:n,style:{width:300},valueRenderer:this.renderProfileName,value:e.key})},e.prototype.render=function(){var t=this.props.profile;return o.createElement("tr",{"data-key":t.language},o.createElement("td",{className:"thin nowrap"},t.languageName),o.createElement("td",{className:"thin nowrap"},this.renderProfileSelect()),o.createElement("td",null,this.state.loading&&o.createElement("i",{className:"spinner"})))},e}(o.PureComponent);function g(t){var e=d()(t.allProfiles,"language"),n=p()(t.profiles,"languageName").map(function(n){return o.createElement(y,{key:n.language,profile:n,possibleProfiles:e[n.language],onChangeProfile:t.onChangeProfile})});return o.createElement("div",{className:"boxed-group boxed-group-inner"},o.createElement("table",{className:"data zebra"},o.createElement("thead",null,o.createElement("tr",null,o.createElement("th",{className:"thin nowrap"},Object(u.l)("language")),o.createElement("th",{className:"thin nowrap"},Object(u.l)("quality_profile")),o.createElement("th",null," "))),o.createElement("tbody",null,n)))}var O=n(899),b=n(896),j=n(254),v=n(969),_=function(){var t=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var n in e)e.hasOwnProperty(n)&&(t[n]=e[n])};return function(e,n){function o(){this.constructor=e}t(e,n),e.prototype=null===n?Object.create(n):(o.prototype=n.prototype,new o)}}(),q=function(t){function e(){var e=null!==t&&t.apply(this,arguments)||this;return e.mounted=!1,e.state={loading:!0},e.handleChangeProfile=function(t,n){var o=e.props.component,r=e.state,i=r.allProfiles,a=r.profiles,c=i&&i.find(function(t){return t.key===n});return(c&&c.isDefault?Object(O.m)(t,o.key):Object(O.d)(n,o.key)).then(function(){if(e.mounted&&a&&c){var n=a.filter(function(e){return e.key!==t}).concat([c]);e.setState({profiles:n}),Object(j.a)(Object(u.m)("project_quality_profile.successfully_updated",c.languageName))}})},e}return _(e,t),e.prototype.componentDidMount=function(){this.mounted=!0,this.checkPermissions()?this.fetchProfiles():Object(v.a)()},e.prototype.componentWillUnmount=function(){this.mounted=!1},e.prototype.checkPermissions=function(){var t=this.props.component.configuration;return!!(t&&t.showQualityProfiles)},e.prototype.fetchProfiles=function(){var t=this,e=this.props.component,n=e.key,o=e.organization;Promise.all([Object(O.y)({organization:o}).then(function(t){return t.profiles}),Object(O.y)({organization:o,project:n}).then(function(t){return t.profiles})]).then(function(e){var n=e[0],o=e[1];t.mounted&&t.setState({loading:!1,allProfiles:n,profiles:o})},function(){t.mounted&&t.setState({loading:!1})})},e.prototype.render=function(){if(!this.checkPermissions())return null;var t=this.state,e=t.allProfiles,n=t.loading,r=t.profiles;return o.createElement("div",{className:"page page-limited"},o.createElement(b.a,{suggestions:"project_quality_profiles"}),o.createElement(i.a,{title:Object(u.l)("project_quality_profiles.page")}),o.createElement(c,null),n?o.createElement("i",{className:"spinner"}):e&&r&&o.createElement(g,{allProfiles:e,profiles:r,onChangeProfile:this.handleChangeProfile}))},e}(o.PureComponent);e.default=q},896:function(t,e,n){"use strict";var o,r=n(0),i=n(4),a=(o=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var n in e)e.hasOwnProperty(n)&&(t[n]=e[n])},function(t,e){function n(){this.constructor=t}o(t,e),t.prototype=null===e?Object.create(e):(n.prototype=e.prototype,new n)}),u=function(t){function e(){return null!==t&&t.apply(this,arguments)||this}return a(e,t),e.prototype.componentDidMount=function(){this.context.suggestions.addSuggestions(this.props.suggestions)},e.prototype.componentDidUpdate=function(t){t.suggestions!==this.props.suggestions&&(this.context.suggestions.removeSuggestions(this.props.suggestions),this.context.suggestions.addSuggestions(t.suggestions))},e.prototype.componentWillUnmount=function(){this.context.suggestions.removeSuggestions(this.props.suggestions)},e.prototype.render=function(){return null},e.contextTypes={suggestions:i.object.isRequired},e}(r.PureComponent);e.a=u},898:function(t,e,n){"use strict";var o,r=n(0),i=n(214),a=n(3),u=(o=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var n in e)e.hasOwnProperty(n)&&(t[n]=e[n])},function(t,e){function n(){this.constructor=t}o(t,e),t.prototype=null===e?Object.create(e):(n.prototype=e.prototype,new n)}),c=Object(a.a)(function(){return Promise.all([n.e(8),n.e(380)]).then(n.bind(null,919))}),s=function(t){function e(){var e=null!==t&&t.apply(this,arguments)||this;return e.mounted=!1,e.state={loading:!1,open:!1},e.fetchContent=function(){e.setState({loading:!0}),n(903)("./"+e.props.doc+".md").then(function(t){var n=t.default;e.mounted&&e.setState({content:n,loading:!1})},function(){e.mounted&&e.setState({loading:!1})})},e.close=function(){e.setState({open:!1})},e}return u(e,t),e.prototype.componentDidMount=function(){this.mounted=!0,document.addEventListener("scroll",this.close,!0)},e.prototype.componentWillReceiveProps=function(t){t.doc!==this.props.doc&&this.setState({content:void 0,loading:!1,open:!1})},e.prototype.componentWillUnmount=function(){this.mounted=!1,document.removeEventListener("scroll",this.close,!0)},e.prototype.renderOverlay=function(){return r.createElement("div",{className:"abs-width-300"},this.state.loading?r.createElement("i",{className:"spinner"}):r.createElement(c,{className:"cut-margins",content:this.state.content,isTooltip:!0}))},e.prototype.render=function(){return r.createElement(i.a,{className:this.props.className,onShow:this.fetchContent,overlay:this.renderOverlay()},this.props.children)},e}(r.PureComponent);e.a=s},899:function(t,e,n){"use strict";n.d(e,"y",function(){return s}),n.d(e,"s",function(){return l}),n.d(e,"j",function(){return p}),n.d(e,"w",function(){return f}),n.d(e,"r",function(){return d}),n.d(e,"q",function(){return m}),n.d(e,"A",function(){return h}),n.d(e,"v",function(){return y}),n.d(e,"i",function(){return g}),n.d(e,"l",function(){return O}),n.d(e,"g",function(){return b}),n.d(e,"o",function(){return j}),n.d(e,"n",function(){return v}),n.d(e,"p",function(){return _}),n.d(e,"h",function(){return q}),n.d(e,"d",function(){return N}),n.d(e,"m",function(){return P}),n.d(e,"z",function(){return E}),n.d(e,"x",function(){return w}),n.d(e,"c",function(){return S}),n.d(e,"u",function(){return k}),n.d(e,"b",function(){return J}),n.d(e,"t",function(){return C}),n.d(e,"e",function(){return x}),n.d(e,"f",function(){return D}),n.d(e,"a",function(){return K}),n.d(e,"k",function(){return z});var o=n(900),r=n.n(o),i=n(953),a=n(5),u=n(10),c=Object.assign||function(t){for(var e,n=1,o=arguments.length;n<o;n++)for(var r in e=arguments[n])Object.prototype.hasOwnProperty.call(e,r)&&(t[r]=e[r]);return t};function s(t){return Object(a.getJSON)("/api/qualityprofiles/search",t).catch(u.a)}function l(t){return Object(a.getJSON)("/api/qualityprofiles/show",t)}function p(t){return Object(a.request)("/api/qualityprofiles/create").setMethod("post").setData(t).submit().then(a.checkStatus).then(a.parseJSON)}function f(t){return Object(a.request)("/api/qualityprofiles/restore").setMethod("post").setData(t).submit().then(a.checkStatus).then(a.parseJSON)}function d(t){return Object(a.getJSON)("/api/qualityprofiles/projects",t).catch(u.a)}function m(t){return Object(a.getJSON)("/api/qualityprofiles/inheritance",{profileKey:t}).catch(u.a)}function h(t){return Object(a.post)("/api/qualityprofiles/set_default",{profileKey:t})}function y(t,e){return Object(a.post)("/api/qualityprofiles/rename",{key:t,name:e})}function g(t,e){return Object(a.postJSON)("/api/qualityprofiles/copy",{fromKey:t,toName:e})}function O(t){return Object(a.post)("/api/qualityprofiles/delete",{profileKey:t})}function b(t,e){return Object(a.post)("/api/qualityprofiles/change_parent",{profileKey:t,parentKey:e})}function j(){return Object(a.getJSON)("/api/qualityprofiles/importers").then(function(t){return t.importers},u.a)}function v(){return Object(a.getJSON)("/api/qualityprofiles/exporters").then(function(t){return t.exporters})}function _(t){return Object(a.getJSON)("/api/qualityprofiles/changelog",t)}function q(t,e){return Object(a.getJSON)("/api/qualityprofiles/compare",{leftKey:t,rightKey:e})}function N(t,e){return Object(a.post)("/api/qualityprofiles/add_project",{profileKey:t,projectKey:e}).catch(u.a)}function P(t,e){return Object(a.post)("/api/qualityprofiles/remove_project",{profileKey:t,projectKey:e}).catch(u.a)}function E(t){return Object(a.getJSON)("/api/qualityprofiles/search_users",t).catch(u.a)}function w(t){return Object(a.getJSON)("/api/qualityprofiles/search_groups",t).catch(u.a)}function S(t){return Object(a.post)("/api/qualityprofiles/add_user",t).catch(u.a)}function k(t){return Object(a.post)("/api/qualityprofiles/remove_user",t).catch(u.a)}function J(t){return Object(a.post)("/api/qualityprofiles/add_group",t).catch(u.a)}function C(t){return Object(a.post)("/api/qualityprofiles/remove_group",t).catch(u.a)}function x(t){return Object(a.postJSON)("/api/qualityprofiles/activate_rules",t)}function D(t){return Object(a.postJSON)("/api/qualityprofiles/deactivate_rules",t)}function K(t){var e=t.params&&r()(t.params,function(t,e){return e+"="+Object(i.a)(t)}).join(";");return Object(a.post)("/api/qualityprofiles/activate_rule",c({},t,{params:e})).catch(u.a)}function z(t){return Object(a.post)("/api/qualityprofiles/deactivate_rule",t).catch(u.a)}},900:function(t,e,n){var o=n(115),r=n(114),i=n(342),a=n(66);t.exports=function(t,e){return(a(t)?o:i)(t,r(e,3))}},901:function(t,e,n){var o=n(162),r=n(340),i=Object.prototype.hasOwnProperty,a=r(function(t,e,n){i.call(t,n)?t[n].push(e):o(t,n,[e])});t.exports=a},903:function(t,e,n){var o={"./branches/no-branch-support.md":[947,358],"./branches/single-branch.md":[946,357],"./editions/datacenter.md":[945,356],"./editions/developer.md":[944,355],"./editions/enterprise.md":[943,354],"./organizations/add-organization-member.md":[942,353],"./organizations/organization.md":[941,352],"./quality-gates/built-in-quality-gate.md":[940,351],"./quality-gates/default-quality-gate.md":[939,350],"./quality-gates/project-homepage-quality-gate.md":[938,349],"./quality-gates/quality-gate-conditions.md":[937,348],"./quality-gates/quality-gate-projects.md":[936,347],"./quality-gates/quality-gate.md":[935,346],"./quality-profiles/built-in-quality-profile.md":[934,345],"./quality-profiles/default-quality-profile.md":[933,344],"./quality-profiles/quality-profile-projects.md":[932,343],"./rules/custom-rule-removal.md":[931,342],"./rules/custom-rules.md":[930,341],"./rules/rule-templates.md":[929,340],"./rules/rules-quality-profiles.md":[928,339]};function r(t){var e=o[t];return e?n.e(e[1]).then(function(){var t=n(e[0]);return"object"==typeof t&&t&&t.__esModule?t:Object.assign({},"object"==typeof t&&t,{default:t})}):Promise.resolve().then(function(){var e=new Error('Cannot find module "'+t+'".');throw e.code="MODULE_NOT_FOUND",e})}r.keys=function(){return Object.keys(o)},r.id=903,t.exports=r},953:function(t,e,n){"use strict";function o(t){return'"'+t.replace(/"/g,'\\"')+'"'}n.d(e,"a",function(){return o})},954:function(t,e,n){var o=n(345),r=n(66);t.exports=function(t,e,n,i){return null==t?[]:(r(e)||(e=null==e?[]:[e]),r(n=i?void 0:n)||(n=null==n?[]:[n]),o(t,e,n))}},969:function(t,e,n){"use strict";var o=n(75),r=n(139),i=n(136);e.a=function(){var t=Object(o.default)(),e=Object(r.a)(),n=window.location.pathname+window.location.search+window.location.hash;t.dispatch(Object(i.c)()),e.replace({pathname:"/sessions/new",query:{return_to:n}})}}}]);
//# sourceMappingURL=297.944a4ad8.chunk.js.map