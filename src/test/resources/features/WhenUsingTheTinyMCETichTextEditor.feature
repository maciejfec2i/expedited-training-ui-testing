@RichTextEditorTextTests
Feature: When using the TinyMCE rich-text editor

  @RichTextEditorTextTest1
  Scenario: the toolbar should reflect the correct format for each inputted content section
    Given the user is on the TinyMCE Text Editor page
    When they input the following content into the text editor
      | text                                                                 | font-style           | font-formatting | font-alignment |
      | Lorem ipsum                                                          | Headings > Heading 1 | Bold            | Align center   |
      | Lorem ipsum dolor sit amet,                                          | Blocks > Paragraph   | Normal          | Align left     |
      | consectetur adipiscing elit,                                         | Blocks > Paragraph   | Normal          | Align left     |
      | "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." | Blocks > Paragraph   | Italic          | Align right    |
    Then the toolbar should reflect the correct format for each inputted content section