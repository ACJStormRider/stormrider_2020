import React from 'react';

class SubcategoryListItem extends React.Component {

//  R E N D E R   M E T H O D
//=====================================================================================================================

    render() {
        const language = this.props.language;   // Declares a language variable and assigns the value to it
                                                // passed from the SubcategoryList.js component as 'language'
        return (
            <div>
                {
                    this.props.subcategory.subcategoryLanguages.map((subcategoryLanguage) =>
                        <>
                        {
                            (subcategoryLanguage.appLanguageCode === language) ?
                                <p>
                                    {subcategoryLanguage.name}
                                </p>
                                :
                                null
                        }
                        </>
                    )
                }
            </div>
        );
    }

}

export default SubcategoryListItem;