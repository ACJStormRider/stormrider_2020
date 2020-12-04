/*
    This is a JavaScript file created to temporarily store data
    used in the website purely for frontend testing purposes
*/

export const product = [
    {
        productId: 1,
        inventory: 10,
        productGroupId: 1,
        lastUpdated: "2020-12-04"
    },
    {
        productId: 2,
        inventory: 7,
        productGroupId: 2,
        lastUpdated: "2020-11-10"
    },
    {
        productId: 3,
        inventory: 15,
        productGroupId: 3,
        lastUpdated: "2020-12-03"
    },
    {
        productId: 4,
        inventory: 20,
        productGroupId: 4,
        lastUpdated: "2020-11-22"
    }
];


export const productGroup = [
    {
        productGroupId: 1,
        basePrice: 200,
        vat: 50
    },
    {
        productGroupId: 2,
        basePrice: 1000,
        vat: 250
    },
    {
        productGroupId: 3,
        basePrice: 400,
        vat: 100
    },
    {
        productGroupId: 4,
        basePrice: 40,
        vat: 10
    }
];


export const subcategory = [
    {
        subCategoryId: 1
    },
    {
        subCategoryId: 2
    },
    {
        subCategoryId: 3
    },
    {
        subCategoryId: 4
    }
];


export const category = [
    {
        categoryId: 1
    },
    {
        categoryId: 2
    }
];

// ==================================================================================================================

export const productGroupHasSubcategory = [
    {
        productGroupId: 1,
        subcategoryId: 1
    },
    {
        productGroupId: 2,
        subcategoryId: 2
    },
    {
        productGroupId: 3,
        subcategoryId: 3
    },
    {
        productGroupId: 4,
        subcategoryId: 4
    }
];


export const subcategoryHasCategory = [
    {
        subcategoryId: 1,
        categoryId: 1
    },
    {
        subcategoryId: 2,
        categoryId: 1
    },
    {
        subcategoryId: 3,
        categoryId: 2
    },
    {
        subcategoryId: 4,
        categoryId: 2
    }
];

// ==================================================================================================================

export const productGroupLanguage = [
    {
        productGroupLanguageId: 1,
        appLanguageCode: "EN",
        productGroupId: 1,
        productGroupName: "Name of the Saddle",
        productGroupDescription: "Vary good saddle"
    },
    {
        productGroupLanguageId: 2,
        appLanguageCode: "EN",
        productGroupId: 2,
        productGroupName: "Name of the Noseband",
        productGroupDescription: "Vary good noseband"
    },
    {
        productGroupLanguageId: 3,
        appLanguageCode: "EN",
        productGroupId: 3,
        productGroupName: "Name of the Horseshoe",
        productGroupDescription: "Vary good horseshoe"
    },
    {
        productGroupLanguageId: 4,
        appLanguageCode: "EN",
        productGroupId: 4,
        productGroupName: "Name of some other metal tool",
        productGroupDescription: "Vary good metal tool"
    }
];


export const subcategoryLanguage = [
    {
        subcategoryLanguageId: 1,
        appLanguageCode: "EN",
        subcategoryId: 1,
        name: "Saddles"
    },
    {
        subcategoryLanguageId: 2,
        appLanguageCode: "EN",
        subcategoryId: 2,
        name: "Nosebands"
    },
    {
        subcategoryLanguageId: 3,
        appLanguageCode: "EN",
        subcategoryId: 3,
        name: "Horseshoes"
    },
    {
        subcategoryLanguageId: 4,
        appLanguageCode: "EN",
        subcategoryId: 4,
        name: "Other Metal thingies"
    }
];


export const categoryLanguage = [
    {
        categoryLanguageId: 1,
        appLanguageCode: "EN",
        categoryId: 1,
        name: "Riding Gear"
    },
    {
        categoryLanguageId: 2,
        appLanguageCode: "EN",
        categoryId: 2,
        name: "Accessories"
    }
]
