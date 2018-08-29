(window.webpackJsonp=window.webpackJsonp||[]).push([[374],{1118:function(e,n){e.exports='---\ntitle: Branches\n---\n\n\x3c!-- sonarqube --\x3e\n\n_Branch analysis is available as part of [Developer Edition](https://redirect.sonarsource.com/editions/developer.html)_\n\n\x3c!-- /sonarqube --\x3e\n\nBranch analysis allows you to\n\n* analyze long-lived branches\n* analyze short-lived branches\n* notify external systems when the status of a short-lived branch is impacted\n\n## Branch Types\n\n### Short-lived\n\nShort-Lived\nThis corresponds to Pull/Merge Requests or Feature Branches. This kind of branch:\n\n* will disappear quickly\n* will be merged rapidly to prevent integration issues\n* is developed for a given version, so the version does not change,\n  and there is no Leak Period concept as such; it\'s all leak period\n  tracks all the new issues related to the code that changed on it.\n\n![conceptual illustration of short-lived branches.](/images/short-lived-branch-concept.png)\n\nFor more, see [Short-lived Branches](/branches/short-lived-branches)\n\n### Long-lived\n\nThis corresponds to "Maintenance" Branches that will house several release versions.\nThis kind of branch will:\n\n* last for a long time\n* inevitably diverge more and more from the other branches\n* house several release versions, each of which must pass the quality gate\n  to go to production not be expected to be merged into another branch\n\n![conceptual illustration of long-lived branches.](/images/long-lived-branch-concept.png)\n\nFor more, see [Long-lived Branches](/branches/long-lived-branches)\n\n### Master / Main Branch\n\nThis is the default, and typically corresponds to what\'s being developed for\nyour next release. This is usually known within a development team as\n"master" or "head", and is what is analyzed when no specific branch parameters\nare provided. It is labeled "Main Branch" and defaults to the name "master",\nbut can be renamed from within the interface. When you are not using Developer Edition, this is the only branch you see.\n\n## Analysis\n\nA branch is created when the `sonar.branch.name` parameter is passed during analysis.\n\n| Parameter Name        | Description                                                                                                                                                                                                                                                             |\n| --------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |\n| `sonar.branch.name`   | Name of the branch (visible in the UI)                                                                                                                                                                                                                                  |\n| `sonar.branch.target` | Name of the branch where you intend to merge your short-lived branch at the end of its life. If left blank, this defaults to the master branch. It can also be used while initializing a long-lived branch to sync the issues from a branch other than the Main Branch. |\n\n### Git History\n\nBy default, TravisCI only fetches the last 50 git commits. You must use `git fetch --unshallow` to get the full history. If you don\'t, new issues may not be assigned to the correct developer.\n\n### Configuring the Branch type\n\nA regular expression is used to determine whether a branch is treated as long-lived or short-lived. By default, branches that have names starting with either "branch" or "release" will be treated as long-lived.\n\nThis can be updated globally in **Configuration > General > Detection** of long-lived branches or at project\'s level in the **Admininstration > Branches**.\n\nOnce a branch type has been set, it cannot be changed. Explicitly, you cannot transform a long-lived to short-lived branch, or vice-versa.\n'}}]);
//# sourceMappingURL=374.73197ee1.chunk.js.map