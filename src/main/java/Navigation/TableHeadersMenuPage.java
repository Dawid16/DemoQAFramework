package Navigation;

import Pages.MenuPage;

/**
 * Created by Dawidek on 2018-03-28.
 */
public class TableHeadersMenuPage extends MenuPage {


    //MenuWithSubMenu
    public static class MenuWithSubMenuHome {

        public static class SubMenuItem1 {
            public static void select() throws Exception {
                MenuSelectorMenuPage.select(homeButtonMenuWithSubMenu, homeItem1MenuWithSubMenu);
            }
        }

        public static class SubMenuItem2 {
            public static void select() throws Exception {
                MenuSelectorMenuPage.select(homeButtonMenuWithSubMenu, homeItem2MenuWithSubMenu);
            }
        }

        public static class SubMenuItem3a {
            public static void select() throws Exception {
                MenuSelectorMenuPage.select(homeButtonMenuWithSubMenu, homeItem3aMenuWithSubMenu);
            }
        }

        public static class SubMenuItem3b {
            public static void select() throws Exception {
                MenuSelectorMenuPage.select(homeButtonMenuWithSubMenu, homeItem3bMenuWithSubMenu);
            }
        }
    }

    public static class MenuWithSubMenuAbout {
        public static void select() throws Exception {
            MenuSelectorMenuPage.select(aboutButtonMenuWithSubMenu);
        }
    }

    public static class MenuWithSubMenuContact {
        public static void select() throws Exception {
            MenuSelectorMenuPage.select(contactButtonMenuWithSubMenu);
        }
    }

    public static class MenuWithSubMenuFAQ {

        public static class SubMenuItem1 {
            public static void select() throws Exception {
                MenuSelectorMenuPage.select(FAQButtonMenuWithSubMenu, FAQItem1MenuWithSubMenu);
            }
        }

        public static class SubMenuItem3 {
            public static void select() throws Exception {
                MenuSelectorMenuPage.select(FAQButtonMenuWithSubMenu, FAQItem3MenuWithSubMenu);
            }
        }
    }

    public static class MenuWithSubMenuNews {

        public static class SubMenuItem1 {
            public static void select() throws Exception {
                MenuSelectorMenuPage.select(newsButtonMenuWithSubMenu, newsItem1MenuWithSubMenu);
            }
        }

        public static class SubMenuItem2 {
            public static void select() throws Exception {
                MenuSelectorMenuPage.select(newsButtonMenuWithSubMenu, newsItem2MenuWithSubMenu);
            }
        }

        public static class SubMenuItem3 {
            public static void select() throws Exception {
                MenuSelectorMenuPage.select(newsButtonMenuWithSubMenu, newsItem3MenuWithSubMenu);
            }
        }
    }

    //SimpleMenu
    public static class SimpleMenuHome {
        public static void select() throws Exception {
            MenuSelectorMenuPage.select(homeButtonSimpleMenu);
        }
    }

    public static class SimpleMenuAbout {
        public static void select() throws Exception {
            MenuSelectorMenuPage.select(aboutButtonSimpleMenu);
        }
    }

    public static class SimpleMenuContact {
        public static void select() throws Exception {
            MenuSelectorMenuPage.select(contactButtonSimpleMenu);
        }
    }

    public static class SimpleMenuFAQ {
        public static void select() throws Exception {
            MenuSelectorMenuPage.select(FAQButtonSimpleMenu);
        }
    }

    public static class SimpleMenuNews {
        public static void select() throws Exception {
            MenuSelectorMenuPage.select(newsButtonSimpleMenu);
        }
    }

}
