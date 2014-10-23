<%@ include file="init-view.jsp" %>

<script type="text/javascript">

    jQuery(document).ready(function($){
    	
    	console.log('dooh');

        jQuery('#${namespace}loadImg').removeClass('none');

        jQuery.ajax({
            url: '${resourceContentURL}' + '&startIndex=0&pageSize=10',
//         	data: { "startIndex": "0", "pageSize": "10"},
            type: 'POST',
            mimeType:'text/html;charset=UTF-8',
            dataType: 'json',
            success: init
        });
        
//         jQuery.post(
//         	'${resourceContentURL}',
//         	{ "startIndex": 0, "pageSize": 10},
//         	init,
//         	'json'
//         	);

        function init(data){
            var editor = new ResourceEditor({
                namespace : '<portlet:namespace/>',
                uploadResourcesURL: '${uploadResourcesURL}',
                resourceContentURL: '${resourceContentURL}',
                searchContentURL: '${searchContentURL}',
                deleteURL: '${deleteURL}',
                editURL: '${editURL}',
                deleteMSG: '<liferay-ui:message key="delete"/>',
                mswJson : data,
                itemCount : 10,
                bundleLabel: '<liferay-ui:message key="resource-editor.bundle"/>',
                keyLabel: '<liferay-ui:message key="resource-editor.key"/>',
                valueLabel: '<liferay-ui:message key="resource-editor.value"/>',
                localeLabel: '<liferay-ui:message key="resource-editor.locale"/>'
            });
        }

    });

</script>