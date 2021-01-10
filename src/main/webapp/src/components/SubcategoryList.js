import React from 'react';
import SubcategoryListItem from "./SubcategoryListItem";

class SubcategoryList extends React.Component {

//  R E N D E R   M E T H O D
//=====================================================================================================================

    render() {
        const language = this.props.language;   // Declares a language variable and assigns the value to it
                                                // passed from the App.js component as 'language'
        return (
            <>
            {
                this.props.subcategories.map((subcategory) =>
                    <SubcategoryListItem
                        subcategory={subcategory}
                        language={language} />
                )
            }
            </>
        );
    }

}

export default SubcategoryList;